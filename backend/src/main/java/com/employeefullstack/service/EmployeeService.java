package com.employeefullstack.service;

import java.util.List;

import com.employeefullstack.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(Long id);

	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployeeDto);
	void deleteEmployee(Long id);
}
