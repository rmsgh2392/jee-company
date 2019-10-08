package com.company.web.daos;

import com.company.web.domains.EmployeeBean;

public interface CompanyDao {
	public boolean insertEmployee(EmployeeBean param);
	public EmployeeBean selectByEmpnoEname(EmployeeBean param);
}
