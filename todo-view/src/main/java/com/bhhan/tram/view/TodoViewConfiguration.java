package com.bhhan.tram.view;

import io.eventuate.tram.consumer.common.NoopDuplicateMessageDetector;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.spring.consumer.kafka.EventuateTramKafkaMessageConsumerConfiguration;
import io.eventuate.tram.spring.events.subscriber.TramEventSubscriberConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */

@Configuration
@Import({EventuateTramKafkaMessageConsumerConfiguration.class, TramEventSubscriberConfiguration.class, NoopDuplicateMessageDetector.class})
public class TodoViewConfiguration {
    @Bean
    public TodoEventConsumer todoEventConsumer(TodoViewService todoViewService){
        return new TodoEventConsumer(todoViewService);
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(TodoEventConsumer todoEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory){
        return domainEventDispatcherFactory.make("todoServiceEvents2", todoEventConsumer.domainEventHandlers());
    }
}
