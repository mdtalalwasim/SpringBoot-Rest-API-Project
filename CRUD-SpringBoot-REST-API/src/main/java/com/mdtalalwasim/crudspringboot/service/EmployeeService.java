package com.mdtalalwasim.crudspringboot.service;

import java.util.List;

import com.mdtalalwasim.crudspringboot.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee save(Employee employee);

}
