package com.example.demo.dto;

public class MessageDto {
    private String id;
    private String messageText;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public MessageDto(String id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }
}
