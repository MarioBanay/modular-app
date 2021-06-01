package com.mario.servlet;

import java.io.IOException;

import com.mario.entity.BookEntity;
import com.mario.repository.BookManager;
import com.mario.usecase.BookRepository;
import com.mario.usecase.CreateBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public HomeServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookRepository repository = (BookRepository) new BookManager();

        CreateBook createBookUsecase = new CreateBook(repository);

        BookEntity book = new BookEntity("Test knjiga", "Petar Peric", 88.23f);

        createBookUsecase.create(book);

        response.getWriter()
                .append("From database: ")
                .append(book.getTitle());
    }

}
