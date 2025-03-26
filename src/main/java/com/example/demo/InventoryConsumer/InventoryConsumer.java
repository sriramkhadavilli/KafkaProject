package com.example.demo.InventoryConsumer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;


import com.example.demo.Model.Order;

@ComponentScan
public class InventoryConsumer {
    @KafkaListener(topics = "order_topic", groupId = "inventory_group")
    public void consume(Order order) {
        System.out.println("Checking inventory for order: " + order);
        // Logic to check and update inventory
    }
}