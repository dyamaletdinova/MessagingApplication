package edu.mum.service;

import edu.mum.domain.User;
 
public interface UserCredentialsService {

	public User findByUserName(String userName);
 }
