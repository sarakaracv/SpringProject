package com.cydeo.controller;

import com.cydeo.dto.AccountDTO;
import com.cydeo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping
    public ResponseEntity<AccountDTO> getById(@RequestParam("id") Long id) throws Exception {
        return ResponseEntity.ok(accountService.getById(id));
    }

}
