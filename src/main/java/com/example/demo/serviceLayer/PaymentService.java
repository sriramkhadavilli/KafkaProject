package com.example.demo.serviceLayer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Order;

@Service
public class PaymentService {
    @KafkaListener(topics = "order_topic", groupId = "payment_group")
    public void processPayment(Order order) {
        System.out.println("Processing payment for order: " + order);
        // Payment processing logic
    }
}