package com.znsd.ssm.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class User implements Serializable{
	private Integer user_id;
	private String user_name;
	private String user_sex;
	private String user_mailsta;
	
	private Clazz clazz;
	
	
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_mailsta() {
		return user_mailsta;
	}
	public void setUser_mailsta(String user_mailsta) {
		this.user_mailsta = user_mailsta;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_sex=" + user_sex + ", user_mailsta="
				+ user_mailsta + ", clazz=" + clazz + "]";
	}



	
}
