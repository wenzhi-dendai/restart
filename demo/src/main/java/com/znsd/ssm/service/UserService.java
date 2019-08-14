package com.znsd.ssm.service;

import java.util.List;

import com.znsd.ssm.entities.User;

public interface UserService {
	public List<User> file();
	
	public int insert(User user);
	
	public int delete(Integer user_id);
	
	public User file1(Integer user_id);
	
	public int update(User user);
	
	public User file5(String user_name);
}
