package com.visionlibrary.repository;

import com.visionlibrary.model.Book;

import com.visionlibrary.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findBookById(Long id);
    void deleteBookById(Long id);
    List<Book> findBookByAuthor(String name);
    List<Book> findBookByTitle(String title);
    List<Book> findBookByPublishingHouse(String publishingHouse);
    List<Book> findBookByCategory(Category category);
    List<Book> findBookByCollection(String collection);
    List<Book> findBookByYearOfLaunch(int yearOfLaunch);
    List<Book> findBookByLanguage(String language);
    List<Book> findBookByBookCode(String bookCode);

}
