package edu.mum.service.impl;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Authority;
import edu.mum.domain.User;


@Service
@Transactional
public class UserServiceImpl implements edu.mum.service.UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void saveFull(User user) {

		final String uri = "http://localhost:8080/TrollAppRestServer/api/user";
        
        user.getUserCredentials().setUser(user);
        for ( Authority a : user.getUserCredentials().getAuthority()) {
        	a.setUsercred(user.getUserCredentials());
        }
		restTemplate.postForObject(uri, user, User.class); 	
	}

	@Override
	public List<User> findAll() {

		final String uri = "http://localhost:8080/TrollAppRestServer/api/users";
		
		User[] users = restTemplate.getForObject(uri, User[].class);
		return Arrays.asList(users);
	}

	@Override
	public User findOne(Long id) {
		final String uri = "http://localhost:8080/TrollAppRestServer/api/user/" + id;
			
		MultiValueMap<String, Long> args = new LinkedMultiValueMap<>();
		args.add("id", id);
		User user =  restTemplate.getForObject(uri, User.class, args); 
		return user;
	}
}
