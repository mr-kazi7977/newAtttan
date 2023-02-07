package com.itvedant.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itvedant.model.EmployeeInfo;


@Repository
public interface AttendRepo extends JpaRepository<EmployeeInfo, Integer> {
	
	
	@Query(value = "SELECT * FROM EmployeeInfo u WHERE u.emplId =:emplid And u.attendanceMonth=:month", nativeQuery = true)
	List<EmployeeInfo> findmonthlydatabyid(Integer emplid,String month);
	
//	Optional<EmployeeInfo> save(EmplData empl);

}
