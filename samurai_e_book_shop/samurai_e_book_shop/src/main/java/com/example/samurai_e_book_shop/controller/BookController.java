package com.example.samurai_e_book_shop.controller;

import com.example.samurai_e_book_shop.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // API to add a book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        // Implement logic to add the book to the list (simulated database)
        books.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // API to update a book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        // Implement logic to update the book in the list (simulated database)
        // Return 404 if the book with the given ID is not found
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setGenre(updatedBook.getGenre());
                book.setPrice(updatedBook.getPrice());
                return new ResponseEntity<>(book, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to fetch a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        // Implement logic to fetch the book from the list (simulated database)
        // Return 404 if the book with the given ID is not found
        for (Book book : books) {
            if (book.getId() == id) {
                return new ResponseEntity<>(book, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("book with id: " + id + " was not found", HttpStatus.NOT_FOUND);
    }

    // API to fetch all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        // Implement logic to fetch all books from the list (simulated database)
        // Return an empty list if no books are found
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
