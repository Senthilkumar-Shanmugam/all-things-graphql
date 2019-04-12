package com.example.graphQLIntro.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphQLIntro.model.Author;
import com.example.graphQLIntro.model.Book;
import com.example.graphQLIntro.repository.AuthorRepository;
import com.example.graphQLIntro.repository.BookRepository;

public class Query implements GraphQLQueryResolver{
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
	
	
	public Iterable<Author> findAllAuthors(){
		return authorRepository.findAll();
	}
	
	public Iterable<Book> findAllBooks(){
		return bookRepository.findAll();
	}
	
	public long countAuthors() {
		return authorRepository.count();
	}
	
	public long countBooks() {
		return bookRepository.count();
	}

}
