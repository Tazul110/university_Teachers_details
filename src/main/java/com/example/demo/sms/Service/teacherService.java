package com.example.demo.sms.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sms.Model.Teacher1;
@Service
public interface teacherService {

	Teacher1 create(Teacher1 teacher);
	List<Teacher1> getAllTeachers();
	Teacher1 viewById(String email);
	
	
}
