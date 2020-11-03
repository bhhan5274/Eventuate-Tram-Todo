package com.bhhan.tram.command;

import com.bhhan.tram.common.TodoCreated;
import com.bhhan.tram.common.TodoDeleted;
import com.bhhan.tram.common.TodoUpdated;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */

@Service
@Transactional
@RequiredArgsConstructor
public class TodoCommandService {
    private final TodoRepository todoRepository;
    private final DomainEventPublisher domainEventPublisher;

    public Todo create(CreateTodoRequest createTodoRequest){
        Todo todo = new Todo(createTodoRequest.getTitle(),
                createTodoRequest.isCompleted(),
                createTodoRequest.getOrder());

        todo = todoRepository.save(todo);
        domainEventPublisher.publish(Todo.class, todo.getId(),
                Collections.singletonList(new TodoCreated(todo.getTitle(), todo.isCompleted(), todo.getExecutionOrder())));

        return todo;
    }

    public void update(Long id, UpdateTodoRequest updateTodoRequest){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));

        todo.setTitle(updateTodoRequest.getTitle());
        todo.setCompleted(updateTodoRequest.isCompleted());
        todo.setExecutionOrder(updateTodoRequest.getOrder());
        todoRepository.save(todo);

        domainEventPublisher.publish(Todo.class,
                id,
                Collections.singletonList(new TodoUpdated(todo.getTitle(), todo.isCompleted(), todo.getExecutionOrder())));
    }

    public void delete(Long id){
        todoRepository.deleteById(id);
        domainEventPublisher.publish(Todo.class, id, Collections.singletonList(new TodoDeleted()));
    }
}
