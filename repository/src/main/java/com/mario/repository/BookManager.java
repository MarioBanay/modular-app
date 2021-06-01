package com.mario.repository;

import com.mario.entity.BookEntity;
import com.mario.usecase.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;


public class BookManager implements BookRepository {

	private static final Logger LOGGER = Logger.getLogger(BookManager.class.getName());

	protected SessionFactory sessionFactory;

	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try 
		{
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
		} 
		
		catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage(), ex);
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public void exit() {
		sessionFactory.close();
	}

	protected void create(Book book) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void update() {
		Book book = new Book();
		book.setId(10);
		book.setTitle("Ultimate Java Programming");
		book.setAuthor("Nam Ha Minh");
		book.setPrice(19.99f);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void delete() {
		Book book = new Book();
		book.setId(1);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(book);

		session.getTransaction().commit();
		session.close();
	}

	public Book read(long id) {
		Session session = sessionFactory.openSession();

		Book book = session.get(Book.class, id);
		session.close();

		return book;

	}

	@Override
	public BookEntity create(BookEntity book) {
		setup();

		Book bookForSave = new Book();
		bookForSave.setAuthor(book.getAuthor());
		bookForSave.setTitle(book.getTitle());
		bookForSave.setPrice(book.getPrice());

		create(bookForSave);

		exit();
		return null;
	}

	@Override
	public BookEntity getBook(long id) {
		setup();

		Book book = read(id);
		BookEntity bookEntity = new BookEntity(book.getTitle(), book.getAuthor(), book.getPrice());

		return bookEntity;
	}


}
