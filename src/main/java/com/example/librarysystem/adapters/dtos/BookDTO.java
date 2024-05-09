package com.example.librarysystem.adapters.dtos;

public record BookDTO (String book_title,
                       String book_author,
                       String book_publisher,
                       String book_genre,
                       String book_pages,
                       String book_language,
                       String book_isbn,
                       Integer avaiable_quantity
                       ){
}
