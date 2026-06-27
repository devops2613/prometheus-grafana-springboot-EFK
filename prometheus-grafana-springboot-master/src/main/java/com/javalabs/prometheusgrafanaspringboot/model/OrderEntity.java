package com.javalabs.prometheusgrafanaspringboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private Integer quantity;

    public OrderEntity() {}

    public OrderEntity(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // getters & setters
}
