package com.library.library.model;

import jakarta.persistence.*;
import lombok.Data;

@Data //добавляет get,set по умолчанию
@Entity //связывает сущность с БД
@Table(name = "books") //показывет каким образом сущность связанна с БД

//это класс который полностью отображает данные в БД
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //ID увлеличивается самостоятельно
        private Long id;
        @Column(name = "book_title") //есть колонка с именем book_title
        private String bookTitle;
        @Column(name = "author")
        private String author;
}
