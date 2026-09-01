package com.employeefullstack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeefullstack.dto.EmployeeDto;
import com.employeefullstack.entity.Employee;
import com.employeefullstack.exception.ResourceNotFoundException;
import com.employeefullstack.mapper.EmployeeMapper;
import com.employeefullstack.repositiory.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Is Not exist with given id"+id));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(java.util.stream.Collectors.toList());
		
	}
	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployeeDto) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Is Not exist with given id"+id));
		
		existingEmployee.setFirstName(updateEmployeeDto.getFirstName());
		existingEmployee.setLastName(updateEmployeeDto.getLastName());
		existingEmployee.setEmail(updateEmployeeDto.getEmail());
		Employee updatedEmployee = employeeRepository.save(existingEmployee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}
	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
		    employeeRepository.deleteById(employee.getId());
		
	}
	
	

}
