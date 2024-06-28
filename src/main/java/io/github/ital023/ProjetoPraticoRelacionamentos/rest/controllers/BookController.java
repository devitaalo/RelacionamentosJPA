package io.github.ital023.ProjetoPraticoRelacionamentos.rest.controllers;

import io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto.BookDTO;
import io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto.BookResultadoDbDTO;
import io.github.ital023.ProjetoPraticoRelacionamentos.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Integer save(@RequestBody BookDTO bookDTO){
        return bookService.salvar(bookDTO);
    }

    @GetMapping("/{id}")
    public BookResultadoDbDTO getOneBook(@PathVariable Integer id){
        return bookService.getOneBooks(id);
    }

    @GetMapping
    public List<BookResultadoDbDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

}
