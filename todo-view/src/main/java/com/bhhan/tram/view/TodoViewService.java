package com.bhhan.tram.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */

@Service
@Transactional
@RequiredArgsConstructor
public class TodoViewService {
    private final TodoViewRepository todoViewRepository;

    public List<TodoView> getTodoViews(){
        return todoViewRepository.findAll();
    }

    public void addTodoView(TodoView todoView){
        todoViewRepository.save(todoView);
    }

    public void deleteTodoView(Long id){
        todoViewRepository.deleteById(id);
    }
}
