package com.pluralsight.repository;

import com.pluralsight.model.Book;

import java.util.List;

public class BookDao extends AbstractDao implements Dao<Book>{
    @Override
    public List<Book> findAll() {
        return null;
    }
}
