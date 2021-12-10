package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QueueSender {
    Logger logger = LoggerFactory.getLogger(QueueSender.class);

    private final RabbitTemplate notificationTemplate;

    @Autowired
    public QueueSender(
        @Qualifier("notificationTemplate") RabbitTemplate notificationTemplate
    ) {
        this.notificationTemplate = notificationTemplate;
    }

    /**
     * Sends an object to RabbitMQ queue
     * @param object
     */
    public void send(Object object) {
        logger.info("SEND NOTIFICATION MESSAGE TO QUEUE : {}", object);
        notificationTemplate.convertAndSend(object);
    }
}
