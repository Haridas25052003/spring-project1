package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Student;

public class StudentDao {
	
	private JdbcTemplate j;

	public void setJ(JdbcTemplate j) {
		this.j = j;
	}

	public int insertStudent(Student s) {
		String s1="insert into student (name, city,percentage) values (?,?,?)";
		
		return j.update(s1,new Object[] {s.getName(),s.getCity(),s.getPercentage()});
	}

}
