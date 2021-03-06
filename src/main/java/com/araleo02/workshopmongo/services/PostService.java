package com.araleo02.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araleo02.workshopmongo.domain.Post;
import com.araleo02.workshopmongo.repository.PostRepository;
import com.araleo02.workshopmongo.services.Exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo; // injecao de dependencia

	public Post findById(String id) {
		Post post = repo.findOne(id);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text); // metodo usando uma query pronta
	}
	
//	public List<Post> findByTitle(String text){
//		return repo.searchTitle(text); // metodo usando uma query customizada
//		
//	}
}
