package com.jac.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "departments")
public class DeptEnt {
	
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "deptId")
	private int deptId;
	
	@Column(name = "deptName")
	private String deptName;
	
	public DeptEnt() {
		
	}
	
	public DeptEnt(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

}
