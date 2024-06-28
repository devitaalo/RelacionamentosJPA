package io.github.ital023.ProjetoPraticoRelacionamentos.service;

import io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto.BookDTO;
import io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto.BookResultadoDbDTO;

import java.util.List;

public interface BookService {

    Integer salvar(BookDTO bookDTO);

    BookResultadoDbDTO getOneBooks(Integer id);

    List<BookResultadoDbDTO> getAllBooks();

}
