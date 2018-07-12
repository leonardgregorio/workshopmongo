package com.araleo02.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.araleo02.workshopmongo.domain.User;
import com.araleo02.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users") // isso define o end point
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() { // isso retorna uma lista de todos os usuarios
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
