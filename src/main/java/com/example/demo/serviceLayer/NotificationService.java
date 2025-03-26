package com.example.demo.serviceLayer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Order;

@Service
public class NotificationService {
    @KafkaListener(topics = "order_topic", groupId = "notification_group")
    public void sendNotification(Order order) {
        System.out.println("Sending notification for order: " + order);
        // Notification logic
    }
}
