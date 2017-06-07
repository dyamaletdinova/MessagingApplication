package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.User;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements edu.mum.service.UserCredentialsService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User findByUserName(String userName) {
		
		final String uri = "http://localhost:8080/TrollAppRestServer/api/auth/login";
		 
		MultiValueMap<String, String> args = new LinkedMultiValueMap<>();
		args.add("username", userName);
		 
		User user =  restTemplate.postForObject(uri, args, User.class);

		return user;
	}
}
