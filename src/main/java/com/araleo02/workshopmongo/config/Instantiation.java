package com.araleo02.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.araleo02.workshopmongo.domain.Post;
import com.araleo02.workshopmongo.domain.User;
import com.araleo02.workshopmongo.dto.AuthorDTO;
import com.araleo02.workshopmongo.dto.CommentDTO;
import com.araleo02.workshopmongo.repository.PostRepository;
import com.araleo02.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.save(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou para SP", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("25/06/2018"), "Bom dia ", "dia dia", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Comentario 1", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Comentario 2 ", sdf.parse("22/05/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Comentario 3", sdf.parse("23/05/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.save(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}
}
