package com.example.graphQLIntro.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphQLIntro.model.Author;
import com.example.graphQLIntro.model.Book;
import com.example.graphQLIntro.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book>{

	private AuthorRepository authorRepository;
	
	public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
	
	public Author getAuthor(Book book) {
		Optional<Author> authorO = authorRepository.findById(book.getAuthor().getId());
		
		return authorO.isPresent() ? authorO.get():null;
	}
}
