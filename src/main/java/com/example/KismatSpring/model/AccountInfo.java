package com.example.KismatSpring.model;

import lombok.Data;

@Data
public class AccountInfo {

    private String name;
    private Address address;
    private String accountNumber;
    private String phoneNumber;
}
