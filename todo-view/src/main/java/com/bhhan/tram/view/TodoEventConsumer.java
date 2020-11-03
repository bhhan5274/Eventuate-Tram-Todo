package com.bhhan.tram.view;

import com.bhhan.tram.common.TodoCreated;
import com.bhhan.tram.common.TodoDeleted;
import com.bhhan.tram.common.TodoUpdated;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import lombok.RequiredArgsConstructor;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */

@RequiredArgsConstructor
public class TodoEventConsumer {
    private final TodoViewService todoViewService;

    public DomainEventHandlers domainEventHandlers(){
        return DomainEventHandlersBuilder
                .forAggregateType("com.bhhan.tram.command.Todo")
                .onEvent(TodoCreated.class, dee -> {
                    TodoCreated event = dee.getEvent();
                    todoViewService.addTodoView(new TodoView(Long.parseLong(dee.getAggregateId()),
                            event.getTitle(),
                            event.isCompleted(),
                            event.getExecutionOrder()));
                })
                .onEvent(TodoUpdated.class, dee -> {
                    TodoUpdated event = dee.getEvent();
                    todoViewService.addTodoView(new TodoView(Long.parseLong(dee.getAggregateId()),
                            event.getTitle(),
                            event.isCompleted(),
                            event.getExecutionOrder()));
                })
                .onEvent(TodoDeleted.class, dee -> {
                    todoViewService.deleteTodoView(Long.parseLong(dee.getAggregateId()));
                })
                .build();
    }
}
