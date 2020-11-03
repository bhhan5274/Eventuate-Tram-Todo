package com.bhhan.tram.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */

@Entity
@Table(name = "TODO_VIEWS")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoView {
    @Id
    @Column(name = "TODO_VIEW_ID")
    private Long id;

    private String title;
    private boolean completed;
    private int executionOrder;

    public TodoView(Long id, String title, boolean completed, int executionOrder) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.executionOrder = executionOrder;
    }
}
