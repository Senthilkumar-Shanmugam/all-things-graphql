package com.example.graphQLIntro.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.graphQLIntro.model.Book;

public interface BookRepository extends CrudRepository<Book,Long>{

}
