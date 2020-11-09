package ru.nugmanov.DNugmanovTestReceiver.service.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.nugmanov.DNugmanovTestReceiver.entity.Message;
import ru.nugmanov.DNugmanovTestReceiver.repositories.MessageRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceImpTest {

    @Mock
    MessageRepository messageRepository;

    @InjectMocks
    MessageServiceImp messageServiceImp;

    private Message message1;
    private Message message2;
    private List<Message> returnedMessages;
    private Date date = new Date();

    @BeforeEach
    void setUp() {
        message1 = new Message(1, date, "value1");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);
        message2 = new Message(2, cal.getTime(), "value2");
        returnedMessages = new ArrayList<>();
        returnedMessages.add(message1);
        returnedMessages.add(message2);
    }

    @Test
    void findAllByOrderByDate() {
        when(messageRepository.findAllByOrderByDate()).thenReturn(returnedMessages);
        List<Message> messages = messageServiceImp.findAllByOrderByDate();
        assertNotNull(messages);
        assertEquals(2, messages.size());
        verify(messageRepository).findAllByOrderByDate();
        assertEquals(messages.get(0), message1);
    }

    @Test
    void save() {
        Message messageToSave = message1;
        when(messageRepository.save((Message) any())).thenReturn(message1);
        Message message = messageServiceImp.save(messageToSave);
        assertNotNull(message);
        assertEquals(messageToSave.getId(), message.getId());
        verify(messageRepository).save((Message) any());
    }
}