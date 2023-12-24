package com.example.demo.sms.Model;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
@Entity
public class Teacher1 {

	@Id
	private String email;
	private String name;
	private String dept;
	private String phone;
	
	@Lob
	private Blob image;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}


	public Teacher1 orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void create(Teacher1 teacher) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
