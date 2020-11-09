package ru.nugmanov.DNugmanovTestReceiver.receiver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ReceiverTest {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    void test() {
        String message = "Hello, world!";
        String queueName = "testQueue";
        jmsTemplate.convertAndSend(queueName, message);
        Object messageObj = this.jmsTemplate.receiveAndConvert(queueName);
        assertNotNull(messageObj);
        assertEquals(messageObj.toString(), message);
    }
}
