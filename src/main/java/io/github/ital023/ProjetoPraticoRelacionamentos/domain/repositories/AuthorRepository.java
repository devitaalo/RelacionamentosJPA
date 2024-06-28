package io.github.ital023.ProjetoPraticoRelacionamentos.domain.repositories;

import io.github.ital023.ProjetoPraticoRelacionamentos.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {


}
