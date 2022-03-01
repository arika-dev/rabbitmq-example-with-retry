package com.poc.receiver.listener;

import com.poc.receiver.MessageException;
import com.poc.receiver.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class RabbitMQ {
    private AtomicLong count = new AtomicLong(0L);
    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public void receivedMessage(Message message) {
        System.out.println(Instant.now() + " ( "+count.incrementAndGet()+" ) Received = : " + message);
        if(message.getMessage().equalsIgnoreCase("Hello"))
            throw new MessageException("Throwing Message exception");

    }
}