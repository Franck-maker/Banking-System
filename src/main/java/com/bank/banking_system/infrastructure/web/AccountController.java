package com.bank.banking_system.infrastructure.web;
import com.bank.banking_system.application.ports.in.AccountUseCase;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.bank.banking_system.domain.model.Account;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    private final AccountUseCase accountUseCase; 

    public AccountController(AccountUseCase accountUseCase){
        this.accountUseCase = accountUseCase; 
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request){

        // We call the use case
        Account createdAccount = accountUseCase.createAccount(request.owner(), request.initialBalance());
        
        // Map the Domain Entity to a Response DTO
        AccountResponse response = new AccountResponse(
            createdAccount.getAccountId(),
            createdAccount.getOwnerName(),
            createdAccount.getBalance()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    

    
}
