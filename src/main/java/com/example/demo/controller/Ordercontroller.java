package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.InventoryConsumer.InventoryProducer;
import com.example.demo.Model.Order;
import com.example.demo.RepoLayer.RepoData;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/orders")
public class Ordercontroller {

    @Autowired
    RepoData orderRepository;

    @Autowired
    InventoryProducer orderProducer;

    public Ordercontroller(RepoData orderRepository, InventoryProducer orderProducer) {
        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    // Place an order
    // URL: POST http://localhost:8080/orders
    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        orderProducer.sendOrder(savedOrder);
        return ResponseEntity.ok(savedOrder);
    }

    // Get all orders
    // URL: GET http://localhost:8080/orders
    @GetMapping("/allorders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    // Get order by ID
    // URL: GET http://localhost:8080/orders/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}