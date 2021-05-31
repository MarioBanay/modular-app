package com.mario.consoleapp;

import com.mario.config.ConsoleAppConfig;
import com.mario.entity.BookEntity;

public class Main {
    public static void main(String[] args) {
        var config = new ConsoleAppConfig();
        var createBook = config.createBook();
        createBook.create(new BookEntity("Title", "Author", 88));
    }
}
