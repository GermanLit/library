package com.library.library.repository;

import com.library.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

//JpaRepository - это интерфейс который генерирует запросы