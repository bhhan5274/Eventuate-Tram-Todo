package com.bhhan.tram.view;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-11-04
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequestMapping(path = "/todos")
@RequiredArgsConstructor
public class TodoViewController {
    private final TodoViewService todoViewService;

    @GetMapping
    public List<TodoView> getTodoViews(){
        return todoViewService.getTodoViews();
    }
}
