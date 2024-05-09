package com.example.librarysystem.domain.loan;

import com.example.librarysystem.domain.book.Book;
import com.example.librarysystem.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name="loan")
@Table(name="loan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date loanDate;
    @Column(name = "returned")
    private boolean returned;

}