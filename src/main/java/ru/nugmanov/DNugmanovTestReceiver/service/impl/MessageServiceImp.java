package ru.nugmanov.DNugmanovTestReceiver.service.impl;

import org.springframework.stereotype.Service;
import ru.nugmanov.DNugmanovTestReceiver.entity.Message;
import ru.nugmanov.DNugmanovTestReceiver.repositories.MessageRepository;
import ru.nugmanov.DNugmanovTestReceiver.service.MessageService;

import java.util.List;

/**
 * Сервис для работы с сообщениями
 *
 * @author NugmanovDT, 05.11.2020
 */
@Service
public class MessageServiceImp implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImp(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> findAllByOrderByDate() {
        return messageRepository.findAllByOrderByDate();
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
