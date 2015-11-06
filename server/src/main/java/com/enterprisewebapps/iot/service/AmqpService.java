package com.enterprisewebapps.iot.service;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Created by dkopel on 10/20/15.
 */
@Service
public class AmqpService
{
    private CachingConnectionFactory connectionFactory;

    @Autowired
    public AmqpService setConnectionFactory(
        CachingConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        return this;
    }

    public RabbitTemplate getTemplate() {
        return new RabbitTemplate(connectionFactory);
    }

    public RabbitAdmin getAdmin() {
        return new RabbitAdmin(connectionFactory);
    }
}
