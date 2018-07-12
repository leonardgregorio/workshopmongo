package com.araleo02.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araleo02.workshopmongo.domain.User;
import com.araleo02.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo; //injecao de dependencia
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
