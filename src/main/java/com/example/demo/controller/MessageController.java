package com.example.demo.controller;

import com.example.demo.config.QueueSender;
import com.example.demo.dto.MessageDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final QueueSender queueSender;

    public MessageController(QueueSender queueSender) {
        this.queueSender = queueSender;
    }

    @GetMapping("/send")
    public void sendMessage() {

        queueSender.send(new MessageDto("2", "Hello anh vinh"));

    }
}
