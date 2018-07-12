package com.araleo02.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.araleo02.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users") // isso define o end point
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>>  findAll() { // isso retorna uma lista de todos os usuarios
		User maria = new User("1", "Maria Brown", "Maria@gmail.com");
		User alex = new User("1", "Alex Green", "Alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}

}
