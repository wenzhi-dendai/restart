package com.znsd.ssm.dao;

import java.util.List;

import com.znsd.ssm.entities.User;

public interface StudentDao {
	
	
	public int add(User user);
	
	public List<User> file();
	
	public User file1(Integer user_id);
	
	public List<User> file2(User user);
	
	public List<User> file3(User user);
	
	public List<User> file4(List item);
	
	public User file5(String user_name);
	
	public int update(User user);
	
	public int insert(User user);
	
	public int delete(Integer user_id);
	
}
