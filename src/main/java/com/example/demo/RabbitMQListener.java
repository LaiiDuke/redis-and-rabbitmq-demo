package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RabbitMQListener implements MessageListener {
    private final Logger log = LoggerFactory.getLogger(RabbitMQListener.class);

    public void onMessage(Message message) {
        try {
            Date startTime = new Date();
            log.warn("START_TIME: " + startTime.getTime());
            log.info("GENERATE_CONTRACT_QUEUE : {}", new String(message.getBody()));


            log.warn("END_TIME: " + (new Date().getTime() - startTime.getTime()));
            log.info("GENERATE_CONTRACT_QUEUE : COMPLETED");
        } catch (Exception ex) {
            log.error("GENERATE_CONTRACT_QUEUE FAILURE");
            ex.printStackTrace();
        }
    }
}
