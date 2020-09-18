package com.example.KismatSpring.api;

import com.example.KismatSpring.model.*;
import com.example.KismatSpring.service.AccountBalanceService;
import com.example.KismatSpring.service.AccountFinder;
import com.example.KismatSpring.service.DepositService;
import com.example.KismatSpring.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class DepositController {

    @Autowired
    DepositService depositService;

    @Autowired
    AccountFinder accountFinder;

    @Autowired
    AccountBalanceService accountBalanceService;

    @Autowired
    WithdrawService withdrawService;

    @PostMapping("/deposit")
    public Reciept deposit(@RequestBody Deposit deposit) throws Exception{
        List<Integer> myDeposits = depositService.deposit(deposit);
        AccountInfo accountInfo = accountFinder.getAccountInfo(deposit.getPinNumber(),deposit.getCardNumber());
        Reciept reciept = new Reciept();
        reciept.setCardNumber(deposit.getCardNumber());
        reciept.setDate(new Date());
        Transaction transaction = new Transaction();
        transaction.setDepositAmount(deposit.getDepositAmount());
        transaction.setCash(accountBalanceService.getAccountBalance()+deposit.getDepositAmount());
        reciept.setTransaction(transaction);
        reciept.setName(accountInfo.getName());
        reciept.setTotalBalance(accountBalanceService.getAccountBalance()+deposit.getDepositAmount());
        return reciept;
    }

    @PutMapping("/withdraw")
    public Reciept withdraw(@RequestBody Withdraw withdraw) throws Exception{
        List<Integer> myWithdraws = withdrawService.withdraw(withdraw);
        AccountInfo accountInfo = accountFinder.getAccountInfo(withdraw.getPinNumber(),withdraw.getCardNumber());
        Reciept reciept = new Reciept();
        reciept.setCardNumber(withdraw.getCardNumber());
        reciept.setDate(new Date());
        Transaction transaction = new Transaction();
        transaction.setWithdrawAmount(withdraw.getWithdrawAmount());
        transaction.setCash(accountBalanceService.getAccountBalance()-withdraw.getWithdrawAmount());
        reciept.setTransaction(transaction);
        reciept.setName((accountInfo.getName()));
        reciept.setTotalBalance(accountBalanceService.getAccountBalance()-withdraw.getWithdrawAmount());
        return reciept;
    }
}
