package com.enterprisewebapps.iot.controller;

import com.enterprisewebapps.iot.service.AmqpService;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by dkopel on 10/20/15.
 */
@RestController
public class Test
{
    AmqpService amqpService;

    @Autowired
    public Test setAmqpService(
        AmqpService amqpService) {
        this.amqpService = amqpService;
        return this;
    }

    @RequestMapping(value = "/")
    public String test() {
        amqpService.getTemplate().send(
            MessageBuilder.withBody("this is a test!".getBytes()).build()
        );
        return "test";
    }
}
