package com.example.librarysystem.adapters.dtos;

import com.example.librarysystem.domain.user.UserType;

public record UserDTO(String name,
                      String last_name,
                      String email,
                      String cpf,
                      Integer borrowed_books_amount
) {
}
