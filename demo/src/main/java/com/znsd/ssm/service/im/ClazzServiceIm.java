package com.znsd.ssm.service.im;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.ssm.dao.ClazzDao;
import com.znsd.ssm.entities.Clazz;
import com.znsd.ssm.service.ClazzService;
@Service
public class ClazzServiceIm implements ClazzService{
	@Autowired
	private ClazzDao clazzDao;
	@Override
	public List<Clazz> file() {
		return clazzDao.file();
	}

}
