package com.employeefullstack.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeefullstack.dto.EmployeeDto;
import com.employeefullstack.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/create")

	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {

		EmployeeDto employeeDto = employeeService.getEmployeeById(id);

		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

		List<EmployeeDto> employees = employeeService.getAllEmployees();

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto updateEmployeeDto) {

		EmployeeDto updatedEmployee = employeeService.updateEmployee(id, updateEmployeeDto);

		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {

		employeeService.deleteEmployee(id);

		return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	}
	
	
	
}
