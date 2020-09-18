package com.example.KismatSpring.service;

import com.example.KismatSpring.model.Deposit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepositService {
    List<Integer> myDeposits = new ArrayList<>();

    public List<Integer>deposit(Deposit deposit){
    myDeposits.add(deposit.getDepositAmount());
    return myDeposits;
    }

    public List<Integer> getAllMyDeposits(){
        return myDeposits;
    }
}
