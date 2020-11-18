package ru.immo.library.service;

import ru.immo.library.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);

    List<Book> getAll();

    List<Book> findByStatus(boolean status);

    List<Book> findAvailableByUserId(Long id);

    List<Book> findAbsentByUserId(Long id);

    void deleteById(Long id);

    Book save(Book book);

}
