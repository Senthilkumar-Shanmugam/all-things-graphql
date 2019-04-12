package com.example.graphQLIntro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.graphQLIntro.model.Author;
import com.example.graphQLIntro.model.Book;
import com.example.graphQLIntro.repository.AuthorRepository;
import com.example.graphQLIntro.repository.BookRepository;
import com.example.graphQLIntro.resolver.BookResolver;
import com.example.graphQLIntro.resolver.Mutation;
import com.example.graphQLIntro.resolver.Query;

@SpringBootApplication
public class GraphQlIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlIntroApplication.class, args);
	}
	
	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}


	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepositor) {
		return new Query(authorRepository,bookRepositor);
	}
	
	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepositor) {
	   return new Mutation(authorRepository,bookRepositor);	
	}
	
	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			Author author = new Author("Herbert", "Schildt");
			authorRepository.save(author);
			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
		};
	}
}
