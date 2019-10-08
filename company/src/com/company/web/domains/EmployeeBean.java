package com.company.web.domains;

import java.io.Serializable;

import lombok.Data;
@Data
public class EmployeeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String empNo,ename,job,mgr,hireDate,sal,comm,deptNo;
}
