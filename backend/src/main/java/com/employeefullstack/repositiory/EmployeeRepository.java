package com.employeefullstack.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeefullstack.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
