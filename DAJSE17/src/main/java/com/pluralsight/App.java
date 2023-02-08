package com.pluralsight;

import com.pluralsight.model.Book;
import com.pluralsight.repository.BookDao;
import com.pluralsight.repository.Dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        // Better way to do above
        Optional<Book> optBook = bookDao.findById(1);
        if(optBook.isPresent()){
            Book book = optBook.get();

            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());

            book.setTitle("Effective Java: Joan Edition");

            bookDao.update(book);
        }

        /*Book newBook = new Book();
        newBook.setTitle("The Catcher in The Rye");
        newBook = bookDao.create(newBook);

        System.out.println("Id: " + newBook.getId());
        System.out.println("Title: " + newBook.getTitle());*/

        books = bookDao.findAll();

        List<Book> updateEntries =
                books.stream()
                        .peek(b -> b.setRating(3))
                        .collect(Collectors.toList());
        bookDao.update(updateEntries);
    }
}
