package com.jac.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jac.login.dao.EmployeeDao;
import com.jac.login.model.EmpEnt;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao empDao;
	

	@Override
	public boolean insertEmp(EmpEnt emp) {
		return empDao.insertEmp(emp) > 0;
	}

	@Override
	public List<EmpEnt> getEmployees() {
		return empDao.getEmployees();
	}

	@Override
	public EmpEnt getEmpById(int empId) {
		return empDao.getEmpById(empId);
	}

	@Override
	public EmpEnt getEmpByFName(String firstName) {
		return empDao.getEmpByFName(firstName);
	}

	@Override
	public EmpEnt getEmpByLName(String lastName) {
		return empDao.getEmpByLName(lastName);

	}

	@Override
	public boolean updateEmployee(EmpEnt emp) {
		return empDao.updateEmployee(emp);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		return empDao.deleteEmployee(empId);
	}


}
