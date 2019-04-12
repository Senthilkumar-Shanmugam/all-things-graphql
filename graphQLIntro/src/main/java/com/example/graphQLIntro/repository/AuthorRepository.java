package com.example.graphQLIntro.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.graphQLIntro.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
