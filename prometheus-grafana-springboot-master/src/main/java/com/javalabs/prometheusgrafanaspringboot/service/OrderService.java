package com.javalabs.prometheusgrafanaspringboot.service;

import com.javalabs.prometheusgrafanaspringboot.metrics.OrderMetrics;
import com.javalabs.prometheusgrafanaspringboot.model.OrderEntity;
import com.javalabs.prometheusgrafanaspringboot.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderMetrics metrics;

    public OrderService(OrderRepository repository, OrderMetrics metrics) {
        this.repository = repository;
        this.metrics = metrics;
    }

    public OrderEntity createOrder(String product, int quantity) {
        return metrics.recordDbCall(() -> {
            OrderEntity order = new OrderEntity(product, quantity);
            OrderEntity saved = repository.save(order);
            metrics.incrementOrders();
            return saved;
        });
    }
}
