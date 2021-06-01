package com.mario.usecase;

import com.mario.entity.BookEntity;

public interface BookRepository {

    BookEntity create(BookEntity book);

    BookEntity getBook(long id);

}
