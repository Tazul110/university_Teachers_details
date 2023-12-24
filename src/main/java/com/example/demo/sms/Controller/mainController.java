package com.example.demo.sms.Controller;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.sms.Model.Teacher1;
import com.example.demo.sms.Repository.teacherRepository;
import com.example.demo.sms.Service.teacherService;

@Controller
public class mainController {

	
	@RequestMapping("/home")
	public String HomePage()
	{
		return "homePage.html";
	}

	
	
	//......... teacher account...............................................
	
	
	@RequestMapping("/createAccount")
	public String Account(Model model)
	{
		return "account.html";
		
	}
	
	@Autowired
	private teacherService teacherServ;
	@PostMapping("/Created_teacher_account")
    public String addImagePost(@RequestParam("teacherName") String name, 
    		@RequestParam("department") String dept,
    		@RequestParam("email") String email,
    		@RequestParam("phone") String phone,
    		
    		@RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException
    {
		 byte[] bytes = file.getBytes();
	     Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        Teacher1 teacher = new Teacher1();
        teacher.setEmail(email);
        teacher.setName(name);
        teacher.setDept(dept);
        teacher.setPhone(phone);
        
        teacher.setImage(blob);
        teacherServ.create(teacher);
        return "redirect:/home";
    }
	
	
	//....end.... ....................................................................
	
	//start 2 ....................................................................................   
		 @GetMapping("/Show_all_Teachers")
//		 public String TestPage()
//			{
//				return "test.html";
//			}
		    public String showTeachers(Model model) {
		        List<Teacher1> teachers = teacherServ.getAllTeachers();
		        model.addAttribute("teachers", teachers);
		        return "teachers_demo";
		    }
		 
		 @GetMapping("/display")
		    public ResponseEntity<byte[]> displayImage(@RequestParam("email") String email) throws IOException, SQLException
		    {
		        Teacher1 image=teacherServ.viewById(email);
		        byte [] imageBytes = null;
		        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
		        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
		    }
	//end 2.......................................................................................	    
	
		    
		  //start 4....................................................................................	
		    @GetMapping("/name")
			public String SearchByNmae()
			{
				return "search_name.html";
			}
		   
		   
		  //end 4.......................................................................................
}
