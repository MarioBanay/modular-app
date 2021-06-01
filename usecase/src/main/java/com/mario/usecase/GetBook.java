package com.mario.usecase;

import com.mario.entity.BookEntity;

public class GetBook {

    BookRepository repository;

    public GetBook(final BookRepository repository) {
        this.repository = repository;
    }

    public BookEntity getBook(long id) {
        return repository.getBook(id);
    }
}
