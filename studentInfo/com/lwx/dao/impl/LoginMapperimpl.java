package com.lwx.dao.impl;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lwx.dao.LoginMapper;
import com.lwx.pojo.Student;
import com.lwx.pojo.User;

	public class LoginMapperimpl implements LoginMapper{

		@Override
		public User  findUserByName(String name) {
			//����Jdbc����
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			//�������ݴ洢����
			User u=null;
			try {
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//��ȡ���Ӷ���
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","123456");
				//����Sql����
				String sql="select * from t_user where uname=? and pwd=?";
				//����Sql�������
				ps=conn.prepareStatement(sql);
				//��ռλ����ֵ
				ps.setString(1, name);
				//ִ��
				rs=ps.executeQuery();
				//����ִ�н��
				while(rs.next()){
					u=new User();
					u.setName(rs.getString("uname"));
					u.setPassword(rs.getString("pwd"));
				}
				//�ر���Դ
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//����
			return u;
		}
		//����UID��ȡ�û���Ϣ
		@Override
		public Student findUserById(String studentId) {
				//����Jdbc����
					Connection conn=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
					//�������ݴ洢����
					Student s=null;
					try {
						//��������
						Class.forName("com.mysql.jdbc.Driver");
						//��ȡ���Ӷ���
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","123456");
						//����Sql����
						String sql="select * from t_user where uid=?";
						//����Sql�������
						ps=conn.prepareStatement(sql);
						//��ռλ����ֵ
						ps.setString(1, studentId);
						//ִ��
						rs=ps.executeQuery();
						//����ִ�н��
						while(rs.next()){
							s=new Student();
							s.setStudentId(rs.getString("uname"));
							
						}
						//�ر���Դ
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//����
					return s;
		}
			
	}


