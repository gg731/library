package ru.immo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.immo.library.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String u);
}
