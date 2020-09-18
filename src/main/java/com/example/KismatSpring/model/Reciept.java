package com.example.KismatSpring.model;

import lombok.Data;

import java.util.Date;

@Data
public class Reciept {

    private String name;
    private String cardNumber;
    private Date date;
    private Transaction transaction;
    private int totalBalance;







}
