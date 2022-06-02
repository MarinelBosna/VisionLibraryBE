package com.visionlibrary.resource;

import com.visionlibrary.model.Book;
import com.visionlibrary.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookResource {
    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks () {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> getBookById (@PathVariable("id") Long id) {
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updateBook = bookService.updateBook(book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByAuthors")
    public ResponseEntity<List<Book>> getBooksByAuthors(@RequestParam String author){
        return new ResponseEntity<>(bookService.findByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/findByTitles")
    public ResponseEntity<List<Book>> getBooksByTitles(@RequestParam String title){
        return new ResponseEntity<>(bookService.findByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/findByPublishingHouses")
    public ResponseEntity<List<Book>> getBooksByPublishingHouses(@RequestParam String publishingHouse){
        return new ResponseEntity<>(bookService.findByPublishingHouse(publishingHouse), HttpStatus.OK);
    }

    @GetMapping("/findByCategories")
    public ResponseEntity<List<Book>> getBooksByCategories(@RequestParam String category){
        return new ResponseEntity<>(bookService.findByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/findByCollections")
    public ResponseEntity<List<Book>> getBooksByCollections(@RequestParam String collection){
        return new ResponseEntity<>(bookService.findByCollection(collection), HttpStatus.OK);
    }

    @GetMapping("/findByYearOfLaunch")
    public ResponseEntity<List<Book>> getBooksByYearOfLaunch(@RequestParam int yearOfLaunch){
        return new ResponseEntity<>(bookService.findByYearOfLaunch(yearOfLaunch), HttpStatus.OK);
    }

    @GetMapping("/findBylanguages")
    public ResponseEntity<List<Book>> getBooksByLanguages(@RequestParam String language){
        return new ResponseEntity<>(bookService.findByLanguage(language), HttpStatus.OK);
    }

    @GetMapping("/findBybookCode")
    public ResponseEntity<List<Book>> getBooksByBookCode(@RequestParam String bookCode){
        return new ResponseEntity<>(bookService.findByBookCode(bookCode), HttpStatus.OK);
    }


    @GetMapping("/sortTitleAsc")
    public ResponseEntity<List<Book>> getTitleBooksAsc(){
        List<Book> books = bookService.findByOrderByTitleAsc();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/sortTitleDesc")
    public ResponseEntity<List<Book>> getTitleBooksDesc(){
        List<Book> books = bookService.findByOrderByTitleDesc();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/sortAuthorAsc")
    public ResponseEntity<List<Book>> getAuthorBooksAsc(){
        List<Book> books = bookService.findByOrderByAuthorAsc();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/sortAuthorDesc")
    public ResponseEntity<List<Book>> getAuthorBooksDesc(){
        List<Book> books = bookService.findByOrderByAuthorDesc();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/sortPublishingHouseAsc")
    public ResponseEntity<List<Book>> getAuthorPublishingHouseAsc(){
        List<Book> books = bookService.findByOrderByPublishingHouseAsc();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/sortPublishingHouseDesc")
    public ResponseEntity<List<Book>> findByOrderByPublishingHouseDesc(){
        List<Book> books = bookService.findByOrderByPublishingHouseDesc();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}