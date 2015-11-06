package com.enterprisewebapps.iot.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by dkopel on 10/20/15.
 */
@Configuration
@EnableRabbit
public class AmqpConfiguration
{
    @Value("${amqp.host}")
    private String AMQP_HOST = null;

    @Value("${amqp.username}")
    private String AMQP_USERNAME = null;

    @Value("${amqp.password}")
    private String AMQP_PASSWORD = null;

    @Value("${amqp.virtualhost}")
    private String AMQP_VIRTUAL_HOST = null;

    private CachingConnectionFactory connectionFactory;

    @Bean
    protected CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory;
        connectionFactory = new
            CachingConnectionFactory(AMQP_HOST);

        connectionFactory.setUsername(AMQP_USERNAME);
        connectionFactory.setPassword(AMQP_PASSWORD);

        connectionFactory.setVirtualHost(AMQP_VIRTUAL_HOST);
        //connectionFactory.setRequestedHeartBeat(HEARTBEAT);
        this.connectionFactory = connectionFactory;
        return connectionFactory;
    }
}
