package com.felipebs.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipebs.workshopmongo.domain.User;
import com.felipebs.workshopmongo.repository.UserRepository;
import com.felipebs.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
