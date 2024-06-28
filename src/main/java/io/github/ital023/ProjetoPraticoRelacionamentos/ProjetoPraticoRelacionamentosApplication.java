package io.github.ital023.ProjetoPraticoRelacionamentos;

import io.github.ital023.ProjetoPraticoRelacionamentos.domain.entities.Author;
import io.github.ital023.ProjetoPraticoRelacionamentos.domain.entities.Book;
import io.github.ital023.ProjetoPraticoRelacionamentos.domain.repositories.AuthorRepository;
import io.github.ital023.ProjetoPraticoRelacionamentos.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetoPraticoRelacionamentosApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired BookRepository bookRepository, @Autowired AuthorRepository authorRepository){
		return args -> {

			Author author = new Author();
			author.setName("Jonh lenu");

			authorRepository.save(author);


			Author author2 = new Author();
			author2.setName("Felipe alves");

			authorRepository.save(author2);

			Book book = new Book();
			book.setName("Boulevard");
			book.setAuthor(author);
			book.setPrice(100.0);

			bookRepository.save(book);

			Book book2 = new Book();
			book2.setName("Liao");
			book2.setAuthor(author2);
			book2.setPrice(50.0);

			bookRepository.save(book2);

			Book book3 = new Book();
			book3.setName("TOm e gerry");
			book3.setAuthor(author);
			book3.setPrice(20.0);

			bookRepository.save(book3);

			Book book4 = new Book();
			book4.setName("a forca");
			book4.setAuthor(author2);
			book4.setPrice(300.0);

			bookRepository.save(book4);
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(ProjetoPraticoRelacionamentosApplication.class, args);
	}

}
