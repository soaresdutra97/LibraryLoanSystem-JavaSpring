package com.example.librarysystem.domain.repositories;

import com.example.librarysystem.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookById(Long id);
}
