package com.mdtalalwasim.crudspringboot.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtalalwasim.crudspringboot.entity.Employee;
import com.mdtalalwasim.crudspringboot.repository.EmployeeRepository;
import com.mdtalalwasim.crudspringboot.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

}
