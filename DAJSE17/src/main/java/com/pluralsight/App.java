package com.pluralsight;

import com.pluralsight.model.Book;
import com.pluralsight.repository.BookDao;
import com.pluralsight.repository.Dao;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Dao<Book> bookDao = new BookDao();

        List<Book> books = bookDao.findAll();

        for(Book book: books){
            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());
        }
    }
}
