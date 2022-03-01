package com.poc.sender.controller;

import com.poc.sender.model.Message;
import com.poc.sender.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class Controller {
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping(value = "/producer")
    public String producer(@RequestBody Message message) throws IOException {
        rabbitMQSender.send(message);
        return "Message sent to the RabbitMQ Successfully";
    }
}