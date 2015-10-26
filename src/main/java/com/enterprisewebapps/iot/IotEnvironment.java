package com.enterprisewebapps.iot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Created by dkopel on 10/18/15.
 */
@EnableAutoConfiguration
@EnableScheduling
@EnableRabbit
@ComponentScan(basePackages = {
    "com.enterprisewebapps.iot.config",
    "com.enterprisewebapps.iot.service",
    "com.enterprisewebapps.iot.controller"
})
public class IotEnvironment
{
    /*

    Create connected environment of interfaces that have functionality
    that describes inputs and outputs.

    Inputs are "things" that produce data

    Outputs are "things" that are invoked as a result of inputs

    An input may be something physical such as a Sensor, or something like
    clicking a link. Input could even be a computer or automated event.

    An output may be something physical such as toggling a light on or off
    or even something like sending a SMS message or a logging something to a file

    All inputs are supposed to be described by the type of input and followed by the way the data is acquired.
    For instance: a motion sensor is a physical input. That data may be acquired via a directly connected
    sensor, or one via sort of network connection across the world. The data will be the same, but how the data
    is acquired is different. The interface would be implemented for a specific remote adapter that would vary
    depending on the protocol, and more. The idea is that at this level the adapter is not important.

    The only question is whether the input is one that is how the data actually inputs. Not how it connects, rather
    is it polling, or a stream of constant data, or only upon request. All of these factors will be higher level properties
     */
    public static void main(String[] args) {
        SpringApplication.run(IotEnvironment.class);
    }
}
