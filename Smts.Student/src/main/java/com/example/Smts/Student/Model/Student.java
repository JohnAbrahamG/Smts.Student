package com.example.Smts.Student.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	private String name;
	
	@Id
	private Long id;
	private Integer age;
	

	public Student(String name, Long id, Integer age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
 

}
