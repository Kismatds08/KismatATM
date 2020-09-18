package com.example.KismatSpring.model;

import lombok.Data;

@Data
public class Withdraw {
    private int withdrawAmount;
    private int pinNumber;
    private String cardNumber;
}
