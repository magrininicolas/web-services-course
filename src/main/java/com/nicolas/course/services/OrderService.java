package com.nicolas.course.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nicolas.course.entities.Order;
import com.nicolas.course.repositories.OrderRepository;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }
}
