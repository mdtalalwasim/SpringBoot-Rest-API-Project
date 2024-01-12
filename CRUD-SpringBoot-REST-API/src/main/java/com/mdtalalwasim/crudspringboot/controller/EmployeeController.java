package com.mdtalalwasim.crudspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/admin")
public class EmployeeController {
	
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("Entering...Home");
		return "admin/employees/employees-home.html";
	}
	
	@GetMapping("/employee-home")
	public String employeeHome(Model model) {
		System.out.println("Entering employee home...");
		return "admin/employees/employees-home.html";
	}
	
	@GetMapping("/employee-edit-form")
	public ModelAndView employeeEdit(Model model) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Entering Employee Edit");
		
		
		
		
		mv.setViewName("admin/employees/employees-edit-form");
		return mv;
	}
	
	@GetMapping("/employee-add-form")
	public ModelAndView employeeAddForm(Model model) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Entering Employee Add Form");
		mv.setViewName("admin/employees/employees-add-form");
		return mv;
	}
	
	

}
