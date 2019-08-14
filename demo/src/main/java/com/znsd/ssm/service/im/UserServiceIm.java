package com.znsd.ssm.service.im;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.ssm.dao.StudentDao;
import com.znsd.ssm.entities.User;
import com.znsd.ssm.service.UserService;

@Service
public class UserServiceIm implements UserService{
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<User> file() {
		
		return studentDao.file();
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return studentDao.insert(user);
	}

	@Override
	public int delete(Integer user_id) {
		// TODO Auto-generated method stub
		return studentDao.delete(user_id);
	}

	@Override
	public User file1(Integer user_id) {
		// TODO Auto-generated method stub
		return studentDao.file1(user_id);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return studentDao.update(user);
	}

	@Override
	public User file5(String user_name) {
		// TODO Auto-generated method stub
		return studentDao.file5(user_name);
	}


	
}
