package com.example.librarysystem.domain.repositories;

import com.example.librarysystem.domain.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findLoanById(Long id);
    Optional<Loan> findByUserId(Long id);


}
