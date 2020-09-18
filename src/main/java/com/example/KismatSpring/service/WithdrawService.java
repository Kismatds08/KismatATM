package com.example.KismatSpring.service;

import com.example.KismatSpring.model.Withdraw;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WithdrawService {
    List<Integer>myWithdraws = new ArrayList<>();

    public List<Integer>withdraw(Withdraw withdraw){
        myWithdraws.add(withdraw.getWithdrawAmount());
        return myWithdraws;
    }
    public List<Integer> getAllMyWithdraws(){return myWithdraws;}
}

