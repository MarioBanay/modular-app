package com.mario.consoleapp;

import com.mario.config.console.ConsoleAppConfig;
import com.mario.entity.BookEntity;

public class Main {
    public static void main(String[] args) {
        var config = new ConsoleAppConfig();
        var createBook = config.createBook();
       // createBook.create(new BookEntity("Title", "Author", 88));

        var getBook = config.getBook();
        BookEntity book = getBook.getBook(26);

        System.out.println(book.toString());
    }
}
