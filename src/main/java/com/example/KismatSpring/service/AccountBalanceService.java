package com.example.KismatSpring.service;

import org.springframework.stereotype.Service;

@Service
public class AccountBalanceService {

    int initialBalance = 500;
    public int getAccountBalance(){
        return initialBalance;

    }
}
