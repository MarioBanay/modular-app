package com.mario.usecase;

import com.mario.entity.BookEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateBookTest {

    private static final BookEntity TEST_BOOK = new BookEntity("T", "A", 10);
    private static BookRepository repository;

    @BeforeAll
    public static void setUp() {
        repository = mock(BookRepository.class);
        when(repository.create(any(BookEntity.class))).thenReturn(TEST_BOOK);
    }

    @Test
    void repositoryCreateShouldReturnTestBook() {
        assertEquals(TEST_BOOK, repository.create(TEST_BOOK));
    }

    @Test
    void createBookCreateBookShouldReturnTestBook() {
        CreateBook createBook = new CreateBook(repository);
        assertEquals(TEST_BOOK, createBook.create(TEST_BOOK));
    }
}