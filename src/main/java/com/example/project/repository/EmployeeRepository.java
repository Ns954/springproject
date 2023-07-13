package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{


	
}
