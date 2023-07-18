package ru.dinara.dao;

import org.springframework.stereotype.Component;
import ru.dinara.models.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {
    private static int BOOK_COUNT;

    private List<Book> books;

    {
        books = new ArrayList<>();

        books.add(new Book(++BOOK_COUNT, "Вселенная", "Иванов Иван", 1920));
        books.add(new Book(++BOOK_COUNT, "Вселенная1", "Иванов Иван1", 1930));
        books.add(new Book(++BOOK_COUNT, "Вселенная2", "Иванов Иван2", 1940));
        books.add(new Book(++BOOK_COUNT, "Вселенная3", "Иванов Иван3", 1950));
        books.add(new Book(++BOOK_COUNT, "Вселенная4", "Иванов Иван4", 1960));
        books.add(new Book(++BOOK_COUNT, "Вселенная5", "Иванов Иван5", 1970));
    }

    public List<Book> index() {
        return books;
    }

    public Book show(int id) {
        return books.stream().filter(book -> book.getId() == id).findAny().orElse(null);
    }

    public void save(Book book) {
        books.add(new Book(++BOOK_COUNT, book.getName(), book.getAuthor(), book.getYear()));
    }

    public void update(int id, Book updatedBook) {
        Book book = show(id);
        book.setName(updatedBook.getName());
        book.setAuthor(updatedBook.getAuthor());
        book.setYear(updatedBook.getYear());
    }

}
