package com.lwx.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwx.dao.StudentMapper;
import com.lwx.pojo.Student;
import com.lwx.service.StudentService;
import com.lwx.untils.PageBean;

@Service
public class StudentServiceImpl implements StudentService {
	
	//����dao��
	@Autowired
	private StudentMapper studentMapper;

	public void setStudentmapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	//���ѧ����Ϣ
	@Override
	public int addStudentInfo(Student student) {
		return studentMapper.addStudentInfo(student);
	}

	//��ѯҪ���µ�ѧ����Ϣ
	@Override
	public Student queryStudetnById(String id) {
		return studentMapper.queryStudentById(id);
	}
	
	//����ѧ����Ϣ
	@Override
	public int updateStudentInfo(Student student) {
		return studentMapper.updateStudentInfo(student);
	}

	//ɾ��ѧ����Ϣ
	@Override
	public int deleteStudentInfoById(String id) {	
		return studentMapper.deleteStudentInfoById(id);
	}

	//��ѯȫ��ѧ����Ϣ
	@Override
	public PageBean<Student> findByPage(int currentPage,String id) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		PageBean<Student> pageBean = new PageBean<Student>();
		
        pageBean.setCurrPage(currentPage);//��װ��ǰҳ
        pageBean.setId(id);
        
		int pageSize=7;//ÿҳ��ʾ��������
		pageBean.setPageSize(pageSize);
		
		//��װ�ܼ�¼��
		int totalCount = studentMapper.selectCount(id);
		pageBean.setTotalCount(totalCount);
		
		//��װ��ҳ��
		double tc = totalCount;
        Double num =Math.ceil(tc/pageSize); //����ȡ��
        pageBean.setTotalPage(num.intValue());
      
		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("studentId",id);
		
		//��װÿҳ��ʾ������		
		List<Student> lists = studentMapper.findByPage(map);
		pageBean.setLists(lists);
		
		return pageBean;
	}

	@Override
	public int restStudent(String id) {
		return studentMapper.restStudent(id);
	}



	

}
