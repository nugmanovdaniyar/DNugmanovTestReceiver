package ru.nugmanov.DNugmanovTestReceiver.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.*;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.nugmanov.DNugmanovTestReceiver.entity.Message;

import javax.jms.ConnectionFactory;

/**
 * Конфигурация Jms
 *
 * @author NugmanovDT, 05.11.2020
 */
@EnableJms
@Configuration
public class JmsConfiguration {

    /**
     * @return factory с конвертором в xml
     */
    @Bean
    public JmsListenerContainerFactory<?> customConnectionFactory(
            @Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer
    ) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Message.class);
        MarshallingMessageConverter converter = new MarshallingMessageConverter(jaxb2Marshaller, jaxb2Marshaller);

        factory.setMessageConverter(converter);

        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
