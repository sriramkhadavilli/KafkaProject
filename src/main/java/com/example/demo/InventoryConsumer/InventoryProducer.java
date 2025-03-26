package com.example.demo.InventoryConsumer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Order;

@Component
public class InventoryProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;
    
    public InventoryProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void sendOrder(Order order) {
        kafkaTemplate.send("order_topic", order);
    }
}
