package ru.immo.library.service;

import ru.immo.library.domain.User;

public interface UserService {

    User findByUsername(String u);

    User saveUser(User u);
}
