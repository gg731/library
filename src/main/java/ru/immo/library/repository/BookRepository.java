package ru.immo.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.immo.library.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByStatus(boolean status);

    @Query(value = "select * from book b inner join user_book ub on b.id = ub.book_id"
            + " and ub.user_id=?1 and ub.status=true", nativeQuery = true)
    List<Book> findAvailableByUserId(Long id);

    @Query(value = "select * from book b inner join user_book ub on b.id = ub.book_id"
            + " and ub.user_id=?1 and ub.status=false", nativeQuery = true)
    List<Book> findAbsentByUserId(Long id);

}
