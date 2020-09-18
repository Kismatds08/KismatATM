package com.example.KismatSpring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) 	//  ignore all null fields
public class Transaction {
    private int depositAmount;
    private int withdrawAmount;
    private int cash;
}
