package com.example.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class mycontroller {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/azure")
	public ResponseEntity<String> health(){
		return ResponseEntity.ok("Succesfully running on Azure!!");
	}
	
	@PostMapping("/employee")
	public String createEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee created";
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
}
