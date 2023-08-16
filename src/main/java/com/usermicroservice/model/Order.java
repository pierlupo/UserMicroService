package com.usermicroservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class Order {

    @Id
    private int orderId;

    private String product;
}
