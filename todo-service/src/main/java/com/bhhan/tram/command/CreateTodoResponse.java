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
public class CreateTodoResponse {
    private Long id;

    public CreateTodoResponse(Long id) {
        this.id = id;
    }
}
