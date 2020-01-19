package com.jac.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jac.login.model.EmpEnt;
import com.jac.login.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ModelAndView getEmpList() {
		ModelAndView mv = new ModelAndView("emp-list");

		List<EmpEnt> students = empService.getEmployees();
		mv.addObject("empList", students);
		mv.addObject("employee", new EmpEnt());

		return mv;
	}
	
	@RequestMapping(value = "/add")
	public ModelAndView insertEmp() {
		ModelAndView mv = new ModelAndView("add-emp");
		mv.addObject("emp", new EmpEnt());
		return mv;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") EmpEnt emp) {
		boolean res = empService.insertEmp(emp);
		ModelAndView mv = new ModelAndView("add-emp");
		
		
		if ( res ) {
			mv.addObject("message", "Employee deleted");
		} else {
			mv.addObject("message", "Something went wrong :(");
		}
		return mv;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("empId") EmpEnt emp) {
		if (empService.updateEmployee (emp))
			return "redirect:/students/getstudents"; //fix this
		else {
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("empId") int empId) {
		
		boolean res = empService.deleteEmployee(empId);		

		ModelAndView mv = new ModelAndView("del-emp");
		
		if ( res ) {
			mv.addObject("message", "Employee deleted");
		} else {
			mv.addObject("message", "Something went wrong :(");
		}
		return mv;
		
	}

}
