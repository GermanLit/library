package com.library.library.service;

import com.library.library.model.Book;
import com.library.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//оболочка в которой принимаются запросы из внешнего мира и вызывает repository метод
@Service //показывает что данный класс является компонентом spring
public class BookService {

    private final BookRepository bookRepository; //repository для изменения данных в БД

    //конструктор автосвязывания
    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository; //инициализация repository
    }
    public Book findById(Long id){ //получение book по id
        return bookRepository.getOne(id); //возращает результат выполнения метода bookRepository.getOne
    }

    public List<Book> findAll(){ //получение всех book которые есть
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){ //сохранение book
        return bookRepository.save(book);
    }

    public void deleteById(Long id){ //удаление book
        bookRepository.deleteById(id);
    }
}
