package com.example.librarysystem.usecases;
import com.example.librarysystem.adapters.dtos.BookDTO;
import com.example.librarysystem.domain.book.Book;
import com.example.librarysystem.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book){
        this.bookRepository.save(book);
    }

    public Book createBook(BookDTO data){
        Book newBook = new Book(data);
        this.saveBook(newBook);
        return newBook;
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

//    public Book findUserByBook(Long id) throws Exception{
//        return this.bookRepository.findBookById(id).orElseThrow(() -> new Exception("Livro não encontrado"));
//    }

}
