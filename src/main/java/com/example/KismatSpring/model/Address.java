package com.example.KismatSpring.model;

import lombok.Data;

@Data
public class Address {

    private String streetAddress;
    private String aptNumber;
    private String city;
    private String state;
    private String zipCode;
}
