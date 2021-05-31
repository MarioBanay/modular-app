package com.mario.usecase;

import com.mario.entity.BookEntity;

public final class CreateBook {

    private final BookRepository repository;

    public CreateBook(final BookRepository repository) {
        this.repository = repository;
    }

    public BookEntity create(final BookEntity book) {
        return repository.create(book);
    }
}
