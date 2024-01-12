package com.mdtalalwasim.crudspringboot.controller.rest;

//import com.mdtalalwasim.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/update-employee/{id}")
	public ResponseData updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
		System.out.println("Update Rest....");
		ResponseData responseData = new ResponseData();
		try {
			
			Employee updatedEmployee =  employeeService.updateEmployee(employee, id);
			
			responseData.setStatusCode(200);
			responseData.setMessage("Employee Updated Successfully");
			responseData.setData(updatedEmployee);
			return responseData;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			responseData.setStatusCode(500);
			responseData.setMessage(e.getMessage());
			responseData.setData(null);
			return responseData;
		}
		
	}

}
