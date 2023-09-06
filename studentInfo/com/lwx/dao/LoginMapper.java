package com.lwx.dao;

import com.lwx.pojo.Student;
import com.lwx.pojo.User;

public interface LoginMapper {
	public User findUserByName(String name);
	
	public Student findUserById(String studentId);
}
