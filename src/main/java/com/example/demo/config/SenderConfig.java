package com.example.demo.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SenderConfig {

    @Value("${rabbitmq.host}")
    private String host;
    @Value("${rabbitmq.port}")
    private int port;

    @Value("${rabbitmq.queue.contract.username}")
    private String username;
    @Value("${rabbitmq.queue.contract.password}")
    private String password;
    @Value("${rabbitmq.queue.contract.queue}")
    private String queue;

    private CachingConnectionFactory connectionFactory;

    @Autowired
    public SenderConfig() {

    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Primary
    @Bean
    public RabbitTemplate notificationTemplate() {
        this.connectionFactory = new CachingConnectionFactory(this.host, this.port);
        this.connectionFactory.setUsername(this.username);
        this.connectionFactory.setPassword(this.password);

        RabbitTemplate template = new RabbitTemplate(this.connectionFactory);
        template.setRoutingKey(this.queue);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
