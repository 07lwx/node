package com.lwx.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.lwx.pojo.Student;

	public interface StudentMapper {
		
		//���ѧ��
		public int addStudentInfo(Student student);
		
		//����ѧ��
		public int updateStudentInfo(Student student);
		
		//��ȡҪ�޸ĵ�ѧ����Ϣ
		public Student queryStudentById(String id);
		
		//ɾ��ѧ��
		public int deleteStudentInfoById(@Param("studentId") String id);

		//��ѯѧ��
		public List<Student> findByPage(HashMap<String,Object> map);
		
		//��ѯ������
	    int selectCount(@Param("studentId")String id);
	    
	    public int restStudent(@Param("studentId")String id);

		public int changePwd(@Param("studentId")String studentId, @Param("newPass")String newPass);
		
		

	    
	}
