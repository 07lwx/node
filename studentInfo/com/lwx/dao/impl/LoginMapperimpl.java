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
			//声明Jdbc对象
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			//声明数据存储对象
			User u=null;
			try {
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//获取连接对象
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","123456");
				//创建Sql命令
				String sql="select * from t_user where uname=? and pwd=?";
				//创建Sql命令对象
				ps=conn.prepareStatement(sql);
				//给占位符赋值
				ps.setString(1, name);
				//执行
				rs=ps.executeQuery();
				//遍历执行结果
				while(rs.next()){
					u=new User();
					u.setName(rs.getString("uname"));
					u.setPassword(rs.getString("pwd"));
				}
				//关闭资源
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
			//返回
			return u;
		}
		//根据UID获取用户信息
		@Override
		public Student findUserById(String studentId) {
				//声明Jdbc对象
					Connection conn=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
					//声明数据存储对象
					Student s=null;
					try {
						//加载驱动
						Class.forName("com.mysql.jdbc.Driver");
						//获取连接对象
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","123456");
						//创建Sql命令
						String sql="select * from t_user where uid=?";
						//创建Sql命令对象
						ps=conn.prepareStatement(sql);
						//给占位符赋值
						ps.setString(1, studentId);
						//执行
						rs=ps.executeQuery();
						//遍历执行结果
						while(rs.next()){
							s=new Student();
							s.setStudentId(rs.getString("uname"));
							
						}
						//关闭资源
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
					//返回
					return s;
		}
			
	}


