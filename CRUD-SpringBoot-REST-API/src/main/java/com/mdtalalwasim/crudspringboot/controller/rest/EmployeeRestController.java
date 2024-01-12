package com.mdtalalwasim.crudspringboot.controller.rest;

//import com.mdtalalwasim.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtalalwasim.crudspringboot.entity.Employee;
import com.mdtalalwasim.crudspringboot.helper.ResponseData;
import com.mdtalalwasim.crudspringboot.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/get-employee-details")
	public List<Employee> getEmployeeList(){
	List<Employee> empList	 = employeeService.getAllEmployees();
		System.out.println(empList.toString());
		return empList;
	}
	
	@PostMapping("/save-employee")
	public ResponseData saveEmployee(@RequestBody Employee employee) {

		ResponseData responseData = new ResponseData();

		try {
			
			Employee emp = employeeService.save(employee);
			
			responseData.setData(emp);
			responseData.setStatusCode(201);
			responseData.setMessage("Employee Save Successfully");
			responseData.setStatus("OK");
			
			return responseData;

		} catch (Exception e) {
			e.printStackTrace();
			responseData.setData(null);
			responseData.setStatusCode(500);
			responseData.setMessage(e.getMessage());
			responseData.setStatus("problem");
			
			return responseData;
		}

		
	}

}
