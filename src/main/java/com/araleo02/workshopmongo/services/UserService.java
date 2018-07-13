package com.araleo02.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araleo02.workshopmongo.domain.User;
import com.araleo02.workshopmongo.dto.UserDTO;
import com.araleo02.workshopmongo.repository.UserRepository;
import com.araleo02.workshopmongo.services.Exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo; // injecao de dependencia

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}
