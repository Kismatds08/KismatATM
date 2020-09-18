package com.example.KismatSpring.model;

import lombok.Data;

@Data
public class Deposit {
    private int depositAmount;
    private int pinNumber;
    private String cardNumber;
}
