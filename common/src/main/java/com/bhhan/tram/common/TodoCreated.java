package com.bhhan.tram.common;

import io.eventuate.tram.events.common.DomainEvent;
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
public class TodoCreated implements DomainEvent {
    private String title;
    private boolean completed;
    private int executionOrder;

    public TodoCreated(String title, boolean completed, int executionOrder){
        this.title = title;
        this.completed = completed;
        this.executionOrder = executionOrder;
    }
}
