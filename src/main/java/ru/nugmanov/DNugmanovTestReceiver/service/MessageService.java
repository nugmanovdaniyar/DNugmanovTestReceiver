package ru.nugmanov.DNugmanovTestReceiver.service;

import ru.nugmanov.DNugmanovTestReceiver.entity.Message;

import java.util.List;

public interface MessageService extends CrudService<Message, Long> {
    List<Message> findAllByOrderByDate();
}
