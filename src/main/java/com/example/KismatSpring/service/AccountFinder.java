package com.example.KismatSpring.service;

import com.example.KismatSpring.model.AccountInfo;
import com.example.KismatSpring.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AccountFinder {

    public AccountInfo getAccountInfo(int pinNumber, String cardNumber) throws Exception {
        if (cardNumberIsValid(cardNumber)) {
            if (pinNumberIsValid(pinNumber, cardNumber)) {
                AccountInfo accountInfo = new AccountInfo();
                accountInfo.setAccountNumber("456256589");
                accountInfo.setName("Tom Hanks");
                accountInfo.setPhoneNumber("512-969-1070");
                Address address = new Address();
                address.setAptNumber(null);
                address.setCity("Minneapolis");
                address.setState("MN");
                address.setZipCode("55105");
                address.setStreetAddress("123 Adam way");
                accountInfo.setAddress(address);
                return accountInfo;
            }else{
                throw new Exception("Invalid pin");
            }
        }else{
            throw new Exception ("Invalid Card Info");
            }
        }

    private boolean cardNumberIsValid(String cardNumber) {
        if (cardNumber.length() < 10) {
            return true;
        } else {
            return false;
        }
    }

    private boolean pinNumberIsValid(int pinNumber, String cardNumber) {
        if (pinNumber == 345) {
            return true;
        }else{
            return false;
        }
    }
}