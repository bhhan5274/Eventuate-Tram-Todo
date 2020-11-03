package com.bhhan.tram.command;

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
@Table(name = "TODOS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    private Long id;

    private String title;
    private boolean completed;
    private int executionOrder;

    public Todo(String title, boolean completed, int executionOrder){
        this.title = title;
        this.completed = completed;
        this.executionOrder = executionOrder;
    }
}
