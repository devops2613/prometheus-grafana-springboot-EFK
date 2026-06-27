package com.javalabs.prometheusgrafanaspringboot.repository;

import com.javalabs.prometheusgrafanaspringboot.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
