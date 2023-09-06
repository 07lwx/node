package com.lwx.service;

import org.apache.ibatis.annotations.Param;
import com.lwx.pojo.Course;
import com.lwx.untils.PageBean;

public interface CourseService {

	//��ȡҪ�޸ĵĿγ���Ϣ
		public Course queryCourseById(String id);

		//��ѯ�γ�
		public PageBean<Course> findByPage(int currentPage,String id);
		
		//��ӿγ�
		public int addCourseInfo(Course course);

		//���¿γ�
		public int updateCourseInfo(Course course);

		//ɾ���γ�
		public int deleteCourseInfoById(@Param("courseId") String id);
		
		public PageBean<Course> query(int currentPage,String id);
		
		public Course query1(String id);

	}

