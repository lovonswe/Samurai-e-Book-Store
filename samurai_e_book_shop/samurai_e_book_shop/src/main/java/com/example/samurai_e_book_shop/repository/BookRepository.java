package com.example.samurai_e_book_shop.repository;

import com.example.samurai_e_book_shop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
