package com.library.library.controller;

import com.library.library.model.Book;
import com.library.library.service.BookService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService; //Этот код просто объявляет приватное поле bookService в классе BookController. Сам класс BookService объявляется в другом месте и BookController просто содержит ссылку на этот сервис.

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books); //model добавь в себя attribute под названием "books" и положи books в результате выполнения данного запроса
        return "book-list";
    }


    @GetMapping("/book-create")
    public String createBookForm(Book book){
        return "book-create";
    }

    @PostMapping("/book-create")
    public String createBook(Book book){ //Метод принимает объект типа Book в качестве параметра
        bookService.saveBook(book); //bookService сохраняет book. вызывов метод saveBook сервиса bookService и передает ему объект book
        return "redirect:/books";
    }

    @GetMapping("book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model){
        Book book = bookService.findById(id); //нужно получить book которая равна bookService.findById(id)
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/book-update")
    public String updateBook(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }
}

//Model model это модель в которую помещаются данный