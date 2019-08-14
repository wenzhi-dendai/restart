package com.znsd.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znsd.ssm.entities.Clazz;


public interface ClazzDao {
	public List<Clazz> file();
	
	public List<Clazz> file1(Integer class_id);
}
