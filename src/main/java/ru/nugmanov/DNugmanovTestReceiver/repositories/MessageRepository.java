package ru.nugmanov.DNugmanovTestReceiver.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nugmanov.DNugmanovTestReceiver.entity.Message;

import java.util.List;

/**
 * Репозиторий сущности Сообщение
 *
 * @author NugmanovDT, 05.11.2020
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    public List<Message> findAllByOrderByDate();
}
