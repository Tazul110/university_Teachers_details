package com.example.demo.sms.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.sms.Model.Teacher1;

@Repository
public interface teacherRepository extends JpaRepository<Teacher1,String>
{
	
	@Query("from Teacher1 pp where pp.phone=?1")
	public List<Teacher1> findByPhone(String phone);

}
