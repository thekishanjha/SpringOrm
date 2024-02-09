package com.spring.orm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//Save
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
	//get the single data(object)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}

	//get All Students(all rows)
	public List<Student> getAllStudents(){
		List<Student> allStudent = this.hibernateTemplate.loadAll(Student.class);
		return allStudent;
	}
	
	//delete the student data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//update student 
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
