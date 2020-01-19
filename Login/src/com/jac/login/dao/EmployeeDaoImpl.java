package com.jac.login.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jac.login.model.EmpEnt;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insertEmp(EmpEnt emp) {
		sessionFactory.getCurrentSession().save(emp);
		sessionFactory.getCurrentSession().save(emp.getDeptId());
		return 1;
	}

	@Override
	public List<EmpEnt> getEmployees() {
		
		return getSession().createQuery("from EmpEnt", EmpEnt.class).list();
	}

	@Override
	public EmpEnt getEmpById(int empId) {
		return (EmpEnt) getSession().get(EmpEnt.class, empId) ;
	}

	@Override
	public EmpEnt getEmpByFName(String firstName) {
		String hql = "from EmpEnt where firstName= :firstName";
		Query query = getSession().createQuery(hql);
		query.setParameter("firstName",firstName);
		if (query.list().size() > 0) {
			return (EmpEnt)query.list().get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public EmpEnt getEmpByLName(String lastName) {
		String hql = "from EmpEnt where lastName= :lastName";
		Query query = getSession().createQuery(hql);
		query.setParameter("lastName",lastName);
		if (query.list().size() > 0) {
			return (EmpEnt)query.list().get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public boolean updateEmployee(EmpEnt emp) {
		getSession().update(emp);
		return true;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		EmpEnt fetchedEmp = getEmpById( empId);
		getSession().delete(fetchedEmp);
		return true;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
