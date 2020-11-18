package ru.immo.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.immo.library.domain.Book;
import ru.immo.library.domain.User;
import ru.immo.library.service.BookServiceImpl;
import ru.immo.library.service.UserServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;
    private BookServiceImpl bookService;

    public UserController(UserServiceImpl userService, BookServiceImpl bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        if (user == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<Set<Book>> getAllBooks(@AuthenticationPrincipal String username) {
        User user = userService.findByUsername(username);
        return new ResponseEntity<>(user.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/absent")
    public ResponseEntity<List<Book>> getAbsentBooks(@AuthenticationPrincipal String username) {
        User user = userService.findByUsername(username);
        return new ResponseEntity<>(bookService.findAbsentByUserId(user.getId()), HttpStatus.OK);
    }

    @GetMapping("/books/available")
    public ResponseEntity<List<Book>> getAvailableBooks(@AuthenticationPrincipal String username) {
        User user = userService.findByUsername(username);
        return new ResponseEntity<>(bookService.findAvailableByUserId(user.getId()), HttpStatus.OK);
    }
}
