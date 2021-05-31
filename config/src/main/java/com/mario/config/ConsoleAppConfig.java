package com.mario.config;

import com.mario.repository.BookManager;
import com.mario.usecase.BookRepository;
import com.mario.usecase.CreateBook;

public class ConsoleAppConfig {

    private final BookRepository repository = new BookManager();

    public CreateBook createBook() {
        return new CreateBook(repository);
    }
}
