package com.bhhan.tram.command;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/todos")
public class TodoCommandController {
    private final TodoCommandService todoCommandService;

    @PostMapping
    public CreateTodoResponse create(@RequestBody CreateTodoRequest createTodoRequest){
        Todo todo = todoCommandService.create(createTodoRequest);
        return new CreateTodoResponse(todo.getId());
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateTodoRequest updateTodoRequest){
        todoCommandService.update(id, updateTodoRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        todoCommandService.delete(id);
    }
}
