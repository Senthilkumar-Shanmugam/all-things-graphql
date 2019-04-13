package com.example.graphQLIntro.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphQLIntro.exception.BookNotFoundException;
import com.example.graphQLIntro.model.Author;
import com.example.graphQLIntro.model.Book;
import com.example.graphQLIntro.repository.AuthorRepository;
import com.example.graphQLIntro.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver{
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
	
	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		authorRepository.save(author);
		return author;
	}
	
	public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
		Book book = new Book();
        book.setAuthor(new Author(authorId));
		book.setTitle(title);
		book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

		bookRepository.save(book);
		return book;
	}
	
	public Boolean deleteBook(Long id) {
		bookRepository.deleteById(id);
		return true;
	}
    
	public Book updateBookPageCount(Integer pageCount, Long id) {
		Optional<Book> book = bookRepository.findById(id);
		Book b = null;
		if(book.isPresent()) {
		    b = book.get();
			b.setPageCount(pageCount);
			bookRepository.save(b);
		}else {
			throw new BookNotFoundException("The book to be updated was not found", id);
		}
		return b;
	}
}
