package com.jac.login.dao;

import java.util.List;

import com.jac.login.model.EmpEnt;


public interface EmployeeDao {
	
	public int insertEmp(EmpEnt emp); //Create
	public List <EmpEnt> getEmployees(); //Read
	public EmpEnt getEmpById(int empId); //Read
	public EmpEnt getEmpByFName(String firstName); //Read
	public EmpEnt getEmpByLName(String lastName); //Read
	public boolean updateEmployee(EmpEnt emp); //Update
	public boolean deleteEmployee(int empId); //Delete

}
