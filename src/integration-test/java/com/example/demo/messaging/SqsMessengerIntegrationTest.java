package com.example.demo.messaging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Note a real test probably needs to setup/teardown to clear queue/queues

@SpringBootTest
public class SqsMessengerIntegrationTest {

    @Autowired
    private SqsMessenger sqsMessenger;

    @Test
    public void sillyExampleTestThatSendsAndReceiveUsingSameQueue() {
        final String messageContent = "this is a test";

        sqsMessenger.send(new DemoMessage(messageContent));
        DemoMessage message = sqsMessenger.getMessage();

        assertEquals(message.getContent(), messageContent);
    }
}
