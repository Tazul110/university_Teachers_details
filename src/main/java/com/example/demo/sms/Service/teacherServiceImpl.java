package com.example.demo.sms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sms.Model.Teacher1;
import com.example.demo.sms.Repository.teacherRepository;

@Service
public class teacherServiceImpl implements teacherService {

	@Autowired
	private teacherRepository teacherRepo;
	public Teacher1 create(Teacher1 teacher)
	{
		return teacherRepo.save(teacher);
	}
	@Override
	public List<Teacher1> getAllTeachers() {
		// TODO Auto-generated method stub
		return teacherRepo.findAll();
	}
	@Override
	public Teacher1 viewById(String email) {
		// TODO Auto-generated method stub
		return teacherRepo.findById(email).get();
	}
	
	
	
}
