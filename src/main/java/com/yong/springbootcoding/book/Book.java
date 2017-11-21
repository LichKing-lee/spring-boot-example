package com.yong.springbootcoding.book;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String reader;

    @Column
    private String isbn;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String description;
}
