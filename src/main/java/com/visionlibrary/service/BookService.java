package com.visionlibrary.service;

import com.visionlibrary.model.Book;
import com.visionlibrary.repository.BookRepository;
import com.visionlibrary.service.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book addBook(Book book){
        book.setBookCode(UUID.randomUUID().toString());
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long id) {
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new BookNotFoundException("Book by id " + id + " was not found"));
    }

    public void deleteBook(Long id){
        bookRepository.deleteBookById(id);
    }


    public List<Book> findByAuthor(String author) {
        return bookRepository.findBookByAuthor(author);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    public List<Book> findByPublishingHouse(String publishingHouse) {
        return bookRepository.findBookByPublishingHouse(publishingHouse);
    }

    public List<Book> findByCategory(String category) {
        return bookRepository.findBookByCategory(category);
    }

    public List<Book> findByCollection(String collection) {
        return bookRepository.findBookByCollection(collection);
    }

    public List<Book> findByYearOfLaunch(int yearOfLaunch) {
        return bookRepository.findBookByYearOfLaunch(yearOfLaunch);
    }

    public List<Book> findByLanguage(String language) {
        return bookRepository.findBookByLanguage(language);
    }

    public List<Book> findByBookCode(String bookCode) {
        return bookRepository.findBookByBookCode(bookCode);
    }


    public List<Book> findByOrderByTitleAsc() {
        return entityManager.createQuery("SELECT p FROM Book p ORDER BY p.title",
                Book.class).getResultList();
    }

    public List<Book> findByOrderByTitleDesc() {
        return entityManager.createQuery("SELECT p FROM Book p ORDER BY p.title DESC",
                Book.class).getResultList();
    }

    public List<Book> findByOrderByAuthorAsc() {
        return entityManager.createQuery("SELECT p FROM Book p ORDER BY p.author",
                Book.class).getResultList();
    }

    public List<Book> findByOrderByAuthorDesc() {
        return entityManager.createQuery("SELECT p FROM Book p ORDER BY p.author DESC",
                Book.class).getResultList();
    }
}
