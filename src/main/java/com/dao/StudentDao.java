package com.dao;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Student;
import com.util.StudentRowMapper;


public class StudentDao {
	
	private JdbcTemplate j;

	public void setJ(JdbcTemplate j) {
		this.j = j;
	}

	//Student s=new Student();
	public int insertStudent(Student s) {
		String s1="insert into student (name, city,percentage) values (?,?,?)";
		
		return j.update(s1,new Object[] {s.getName(),s.getCity(),s.getPercentage()});
	}
	
	public int deleteStudentById(int id) {
		String sql="delete from student where id=?";
		return j.update(sql,id);
	}

	public Student findStudentById(int id) {
		String sql="select id,name,city,percentage from student where id=?";
		
		List<Student> list=j.query(sql,new StudentRowMapper(),id);
		return (list.isEmpty())? null:list.get(0);
	}
	
	public List<Student> findAllStudent(){
		String sql="delete id,name,city,percentage from student";
		
		return j.query(sql,new StudentRowMapper());
	}
	
	public int updateStudent(Student s) {
		String sql="update Student set name=? , city=? , percentage=? where id=?";
		return j.update(sql,new Object[] {s.getName(),s.getCity(),s.getPercentage(),s.getId() });
	}
}
