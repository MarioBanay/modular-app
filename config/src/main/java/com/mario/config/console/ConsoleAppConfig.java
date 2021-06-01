package com.mario.config.console;

import com.mario.repository.BookManager;
import com.mario.usecase.BookRepository;
import com.mario.usecase.CreateBook;
import com.mario.usecase.GetBook;

public class ConsoleAppConfig {

    private final BookRepository repository = new BookManager();

    public CreateBook createBook() {
        return new CreateBook(repository);
    }

    public GetBook getBook(){
        return new GetBook(repository);
    }


}
