package com.denisa.smart_expense_tracker.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateExpenseRequest {
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private Double amount;

    private String description;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "User is required")
    private Long userId;

    @NotNull(message = "Category id is required")
    private Long categoryId;
}
