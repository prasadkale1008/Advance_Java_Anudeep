package com.example.demo.EmployeeController;
 
import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeEntity.Employee;





@RestController
@RequestMapping("/Employee")
public class EmpController {
	private Map<Long,Employee> empEntry=new HashMap<>();
	
	@GetMapping()
	public List<Employee> getAll(){
		return new ArrayList<>(empEntry.values());
	}
	
	@PostMapping
	public boolean createEntry(@RequestBody Employee myEntry) {
		empEntry.put(myEntry.getEmpId(), myEntry);
		return true;
	}
	
	
	//Get individual student data by their id
	@GetMapping("id/{myId}")
	public Employee getStudentsById(@PathVariable Long myId) {
		return  empEntry.get(myId);
	}
	
	
	//delete Employee individually by their id
	@DeleteMapping("id/{myId}")
	public Employee deleteStudentById(@PathVariable Long myId) {
		return empEntry.remove(myId);
	}
	
	//update Employee by their id
	@PutMapping("/id/{id}")
	public Employee updateStudentById(@PathVariable Long id,@RequestBody Employee myEntry) {
		return empEntry.put(id, myEntry);
	}
	

	@GetMapping("/abc")
	public String healthCheck() {
		return "Site is working";
	}
	
	
}
