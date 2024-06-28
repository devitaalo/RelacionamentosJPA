package io.github.ital023.ProjetoPraticoRelacionamentos.service.impl;

import io.github.ital023.ProjetoPraticoRelacionamentos.exception.RegraNegocioException;
import io.github.ital023.ProjetoPraticoRelacionamentos.domain.entities.Author;
import io.github.ital023.ProjetoPraticoRelacionamentos.domain.entities.Book;
import io.github.ital023.ProjetoPraticoRelacionamentos.domain.repositories.AuthorRepository;
import io.github.ital023.ProjetoPraticoRelacionamentos.domain.repositories.BookRepository;
import io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto.BookDTO;
import io.github.ital023.ProjetoPraticoRelacionamentos.rest.dto.BookResultadoDbDTO;
import io.github.ital023.ProjetoPraticoRelacionamentos.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional
    public Integer salvar(BookDTO bookDTO) {

        Author author = authorRepository.findById(bookDTO.getAuthor_id()).orElseThrow(() -> new RegraNegocioException("Author not found"));

        Book book = Book
                .builder()
                .name(bookDTO.getName())
                .author(author)
                .price(bookDTO.getPrice())
                .build();

        return bookRepository.save(book).getId();
    }

    @Override
    public BookResultadoDbDTO getOneBooks(Integer id) {

        Book book = bookRepository.findBookWithAuthor(id)
                .orElseThrow(() -> new RegraNegocioException("Book not found with id: " + id));

        return BookResultadoDbDTO
                .builder()
                .name(book.getName())
                .nameAuthor(book.getAuthor().getName())
                .price(book.getPrice())
                .build();
    }

    @Override
    public List<BookResultadoDbDTO> getAllBooks() {
        
          List<Book> books = bookRepository.getAllBooks().orElseThrow(() -> new RegraNegocioException("DEU RUIM"));

          return converter(books);

    }

    private List<BookResultadoDbDTO> converter(List<Book> books){
        if(books.isEmpty()){
            throw new RegraNegocioException("Nao e possivel realizar uma busca sem livros");
        }
        return books
                .stream()
                .map( book -> {

                    BookResultadoDbDTO bookResultadoDbDTO = new BookResultadoDbDTO();

                    bookResultadoDbDTO.setName(book.getName());
                    bookResultadoDbDTO.setPrice(book.getPrice());
                    bookResultadoDbDTO.setNameAuthor(book.getAuthor().getName());

                    return bookResultadoDbDTO;

                }).collect(Collectors.toList());

    }

}
