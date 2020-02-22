package com.example.demo.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component("sqsMessenger")
public class SqsMessenger {

    @Value("${cloud.aws.endpoint.uri}")
    private String sqsEndPoint;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void send(DemoMessage message) {
        queueMessagingTemplate.convertAndSend(sqsEndPoint, message);
    }

    // Note there is an API for listening to queues so rather than just invoking receive etc methods.
    public DemoMessage getMessage() {
        return queueMessagingTemplate.receiveAndConvert(sqsEndPoint, DemoMessage.class);
    }
}
