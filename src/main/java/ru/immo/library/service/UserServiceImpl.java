package ru.immo.library.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.immo.library.domain.User;
import ru.immo.library.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User findByUsername(String u) {
        return repository.findByUsername(u);
    }

    @Override
    public User saveUser(User u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return repository.save(u);
    }
}
