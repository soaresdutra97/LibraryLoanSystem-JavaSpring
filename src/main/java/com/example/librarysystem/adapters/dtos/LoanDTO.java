package com.example.librarysystem.adapters.dtos;

import java.util.Date;

public record LoanDTO(Long userId,
                      Long id,
                      Long bookId,
                      Date loanDate,
                      Date dueDate,
                      boolean returned) {
}
