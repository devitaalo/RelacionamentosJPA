package io.github.ital023.ProjetoPraticoRelacionamentos.domain.repositories;

import io.github.ital023.ProjetoPraticoRelacionamentos.domain.entities.Book;
import io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto.BookResultadoDbDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b JOIN FETCH b.author WHERE b.id = :bookId")
    Optional<Book> findBookWithAuthor(@Param("bookId") Integer bookId);

    @Query("SELECT b FROM Book b JOIN FETCH b.author")
    Optional<List<Book>> getAllBooks();

}
