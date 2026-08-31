package com.employeefullstack.service;

import org.springframework.stereotype.Service;

import com.employeefullstack.dto.EmployeeDto;
import com.employeefullstack.entity.Employee;
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
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id).orElse(null);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	

}
