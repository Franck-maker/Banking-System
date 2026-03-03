package com.bank.banking_system.infrastructure.web;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public record CreateAccountRequest(
    @NotBlank(message = "Owner name is required")
    String owner, 
    
    @NotNull(message = "Initial balance cannot be null")
    @Min(value = 0, message = "Initial balance must be non-negative")
    BigDecimal initialBalance) {  }
