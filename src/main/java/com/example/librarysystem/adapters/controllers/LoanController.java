package com.example.librarysystem.adapters.controllers;

import com.example.librarysystem.adapters.dtos.LoanDTO;
import com.example.librarysystem.domain.loan.Loan;
import com.example.librarysystem.usecases.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    //Cria um empréstimo
    @PostMapping("/create")
    public Loan createLoan(@RequestBody LoanDTO dto) throws Exception{
        Loan newLoan = this.loanService.createLoan(dto);
        return new ResponseEntity<>(newLoan, HttpStatus.OK).getBody();
    }

    //Devolve um livro

    @PostMapping("/devolver")
    public void returnLoan(@RequestBody LoanDTO dto){
        this.loanService.returnLoan(dto);
    }

    //Obtem informações do empréstimo pelo ID
    @GetMapping("/{loanId}")
    public List<Loan> getLoanById(@PathVariable Long loanId){
        return this.loanService.getLoanById(loanId);
    }

    @GetMapping("/retornatudo")
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = this.loanService.getAllLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
}
