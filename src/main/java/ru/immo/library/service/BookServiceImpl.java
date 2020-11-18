package ru.immo.library.service;

import org.springframework.stereotype.Service;
import ru.immo.library.domain.Book;
import ru.immo.library.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findByStatus(boolean status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Book> findAvailableByUserId(Long id) {
        return repository.findAvailableByUserId(id);
    }

    @Override
    public List<Book> findAbsentByUserId(Long u) {
        return repository.findAbsentByUserId(u);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Book save(Book book) { return repository.save(book); }
}