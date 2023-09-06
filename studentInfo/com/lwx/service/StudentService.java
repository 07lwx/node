package com.lwx.service;

import com.lwx.pojo.Student;
import com.lwx.untils.PageBean;

public interface StudentService {
	
	public int addStudentInfo(Student student);
		
	public int updateStudentInfo(Student student);
	
	public Student queryStudetnById(String id);
		
	public int deleteStudentInfoById(String id);
	
	public PageBean<Student> findByPage(int currentPage ,String id);

	public int restStudent(String id);
	
	
}
