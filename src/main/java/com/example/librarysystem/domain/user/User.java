package com.example.librarysystem.domain.user;

import com.example.librarysystem.adapters.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String last_name;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String cpf;
    private Integer borrowed_books_amount;
    //@Enumerated(EnumType.STRING)
    //private UserType userType;

    public User(UserDTO data){
        this.name = data.name();
        this.last_name = data.last_name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.borrowed_books_amount = data.borrowed_books_amount();
        //this.userType = data.userType();
    }
}