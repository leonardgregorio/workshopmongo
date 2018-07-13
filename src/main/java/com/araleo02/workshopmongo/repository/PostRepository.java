package com.araleo02.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.araleo02.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends  MongoRepository<Post, String>{

		
}
