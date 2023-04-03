package com.faisal.spp.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Pembayaran {
    private String id;
    private BigInteger amount;
}
