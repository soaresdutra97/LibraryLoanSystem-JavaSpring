package com.example.librarysystem.domain.book;

import com.example.librarysystem.adapters.dtos.BookDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="books")
@Table(name="books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String book_title;
    private String book_author;
    private String book_publisher;
    private String book_genre;
    private String book_pages;
    private String book_language;
    private String book_isbn;
    private Integer avaiable_quantity;

    public Book(BookDTO data){

        this.book_title = data.book_title();
        this.book_author = data.book_author();
        this.book_publisher = data.book_publisher();
        this.book_genre = data.book_genre();
        this.book_pages = data.book_pages();
        this.book_language = data.book_language();
        this.book_isbn = data.book_isbn();
        this.avaiable_quantity = data.avaiable_quantity();
    }
}