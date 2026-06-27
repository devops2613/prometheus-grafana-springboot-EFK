package com.javalabs.prometheusgrafanaspringboot.controller;


import com.javalabs.prometheusgrafanaspringboot.model.OrderEntity;
import com.javalabs.prometheusgrafanaspringboot.service.OrderService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public OrderEntity createOrder(@RequestParam String product, @RequestParam int quantity) {
        return service.createOrder(product, quantity);
    }
}
