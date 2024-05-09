CREATE TABLE loan (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    book_id BIGINT,
    loan_date DATE,
    due_date DATE,
    returned BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);
