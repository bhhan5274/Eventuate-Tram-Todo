package com.bhhan.tram.command;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */
public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(Long id) {
        super(String.format("Todo with id=%d not found", id));
    }
}
