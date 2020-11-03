package com.bhhan.tram.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */

@Getter
@Setter
@NoArgsConstructor
public class CreateTodoRequest {
    private String title;
    private boolean completed;
    private int order;

    public CreateTodoRequest(String title, boolean completed, int order) {
        this.title = title;
        this.completed = completed;
        this.order = order;
    }
}
