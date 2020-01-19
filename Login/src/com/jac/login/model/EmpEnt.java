package com.jac.login.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name = "employees")
public class EmpEnt {
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "empId")
	private int empId;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "deptId")
	private DeptEnt deptId;
	
	@Column(name = "startDate", nullable = false)
	private Date startDate;
	
	@Column(name = "endDate")
	private Date endDate;
	
	public EmpEnt () {
		
	}
	
	public EmpEnt(int empId, String firstName, String lastName, DeptEnt deptId, Date startDate, Date endDate) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptId = deptId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public DeptEnt getDeptId() {
		return deptId;
	}

	public void setDeptId(DeptEnt deptId) {
		this.deptId = deptId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
}

