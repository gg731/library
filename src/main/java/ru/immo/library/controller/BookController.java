package ru.immo.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.immo.library.domain.Book;
import ru.immo.library.service.BookServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBook() {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        if (book == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        var chek = bookService.findById(id);
        if (chek.isEmpty() || !chek.get().isStatus()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/change-status/{id}")
    public ResponseEntity<Book> getFreeBooks(@PathVariable long id) {
        var chekBook = bookService.findById(id);
        if (chekBook == null) return ResponseEntity.badRequest().build();

        Book book = chekBook.get();
        book.setStatus(!book.isStatus());
        bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Book>> getAvailable() {
        return new ResponseEntity<>(bookService.findByStatus(true), HttpStatus.OK);
    }

    @GetMapping("/absent")
    public ResponseEntity<List<Book>> getAbsentBooks() {
        return new ResponseEntity<>(bookService.findByStatus(false), HttpStatus.OK);
    }
}
