package ru.nugmanov.DNugmanovTestReceiver.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.nugmanov.DNugmanovTestReceiver.entity.Message;
import ru.nugmanov.DNugmanovTestReceiver.service.impl.MessageServiceImp;

/**
 * Получает сообщение из очереди и сохраняет в БД
 *
 * @author NugmanovDT, 05.11.2020
 */
@Component
public class MessageReceiver {

    private final MessageServiceImp messageServiceImp;

    public MessageReceiver(MessageServiceImp messageServiceImp) {
        this.messageServiceImp = messageServiceImp;
    }

    /**
     * Получает сообщение из очереди и сохраняет в БД
     *
     * @param message - сообщение из очереди
     */
    @JmsListener(destination = "${message.queue.name}", containerFactory = "customConnectionFactory")
    public void receiveMessage(Message message) {
        messageServiceImp.save(message);
    }
}