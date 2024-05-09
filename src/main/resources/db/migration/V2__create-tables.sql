CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    book_title VARCHAR(255) NOT NULL,
    book_author VARCHAR(255) NOT NULL,
    book_publisher VARCHAR(10),
    book_genre VARCHAR(255),
    book_pages VARCHAR(10),
    book_language VARCHAR(50),
    book_isbn VARCHAR(20),
    avaiable_quantity INT NOT NULL
);