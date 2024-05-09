package com.example.librarysystem.usecases;
import com.example.librarysystem.adapters.dtos.LoanDTO;
import com.example.librarysystem.domain.book.Book;
import com.example.librarysystem.domain.loan.Loan;
import com.example.librarysystem.domain.repositories.BookRepository;
import com.example.librarysystem.domain.repositories.LoanRepository;
import com.example.librarysystem.domain.repositories.UserRepository;
import com.example.librarysystem.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Loan createLoan(LoanDTO loan){

        //Verifica se o usuário existe
        User user = this.userRepository.findUserById(loan.userId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        //Verifica se o livro existe está disponível para empréstimo
        Book book = this.bookRepository.findBookById(loan.bookId()).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (book.getAvaiable_quantity() <= 0){
            throw new RuntimeException("Livro não disponível para empréstimo");
        }

        //Verifica se o usuário já atingiu o limite de empréstimos
        if(user.getBorrowed_books_amount() >= 3){
            throw new RuntimeException("Usuário já atingiu o limite de 3 empréstimos");
        }

        //Cria novo empréstimo

        Loan newLoan = new Loan();
        newLoan.setUser(user);
        newLoan.setBook(book);
        newLoan.setLoanDate(new Date());
        //Define a data de devolução (exemplo 7 dias a partir da data atual)
        newLoan.setLoanDate(Date.from(new Date().toInstant().plusSeconds(7 * 24 *60 * 60)));
        newLoan.setReturned(false);

        //Atualiza a quantidade disponíveis do livro
        book.setAvaiable_quantity(book.getAvaiable_quantity() - 1);
        bookRepository.save(book);

        //Atualiza quantidade de livros do usuário
        user.setBorrowed_books_amount(user.getBorrowed_books_amount() +1);
        userRepository.save(user);

        //Salva o novo empréstimo
        return loanRepository.save(newLoan);
    }

    public void returnLoan(LoanDTO loanDTO){

        //Busca empréstimo pelo ID
        Loan loan = this.loanRepository.findLoanById(loanDTO.id()).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));



        // Verifica se o livro já foi devolvido
        if (loan.isReturned()) {
            throw new RuntimeException("Este livro já foi devolvido");
        }

        //atualiza a data de devolução e marca o livro como devolvido
        loan.setReturned(true);
        loanRepository.save(loan);


        //Atualiza a quantidade disponível do livro
        Book book = loan.getBook();
        book.setAvaiable_quantity(book.getAvaiable_quantity() +1);
        bookRepository.save(book);

        //Atualiza a quantidade de livros do usuário
        User user = loan.getUser();
        user.setBorrowed_books_amount(user.getBorrowed_books_amount() -1);
        userRepository.save(user);
    }

    //Retorna todos os empréstimos

    public List<Loan> getAllLoans(){
        return this.loanRepository.findAll();
    }

    public List<Loan> getLoanById(Long loanId){
      return this.loanRepository.findAllById(Collections.singleton(loanId));

    }
}
