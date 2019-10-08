package com.company.web.services;

import com.company.web.domains.EmployeeBean;

public interface CompanyService {
	public boolean join (EmployeeBean param);
	public EmployeeBean login(EmployeeBean param);
}
