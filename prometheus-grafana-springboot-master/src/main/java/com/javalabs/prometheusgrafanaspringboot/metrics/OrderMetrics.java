package com.javalabs.prometheusgrafanaspringboot.metrics;

import io.micrometer.core.instrument.*;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;


@Component
public class OrderMetrics {

    private final Counter ordersCreated;
    private final Timer dbTimer;

    public OrderMetrics(MeterRegistry registry) {
        this.ordersCreated = Counter.builder("orders_created_total")
                .description("Total orders created")
                .register(registry);

        this.dbTimer = Timer.builder("orders_db_duration")
                .description("DB interaction duration")
                .register(registry);
    }

    public void incrementOrders() {
        ordersCreated.increment();
    }

    public <T> T recordDbCall(Supplier<T> supplier) {
        return dbTimer.record(supplier);
    }
}
