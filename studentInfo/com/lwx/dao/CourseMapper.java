package com.lwx.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.lwx.pojo.Course;

public interface CourseMapper {
	
	//��ȡҪ���¿γ̵���Ϣ
	public Course queryCourseById(@Param("courseId") String id);
	
	//��ӿγ�
	public int addCourseInfo(Course course);

	// ���¿γ�
	public int updateCourseInfo(Course course);

	// ɾ���γ�
	public int deleteCourseInfoById(@Param("courseId")String id);
	
	//��ѯ�γ�
	public List<Course> findByPage(HashMap<String,Object> map);

	//��ѯ������
	public int selectCount(@Param("courseId")String id);
	
	public List<Course> query(HashMap<String,Object> map);
	
	public int selectcount(String id);
	
	public Course query1(String id);
}

