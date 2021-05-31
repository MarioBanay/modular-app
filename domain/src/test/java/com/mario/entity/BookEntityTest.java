package com.mario.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BookEntityTest {

    private static final BookEntity TEST_BOOK = new BookEntity("T", "A", 10);

    @Test
    void toStringShouldReturnTestString() {

        BookEntity book = TEST_BOOK;
        String testString = "Book [title=" + book.getTitle() + ", author=" + book.getAuthor() + ", price=" + book.getPrice() + "]";
        assertEquals(testString, book.toString());

    }
}