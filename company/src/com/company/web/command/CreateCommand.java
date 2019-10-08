package com.company.web.command;

import javax.servlet.http.HttpServletRequest;

import com.company.web.domains.EmployeeBean;
import com.company.web.serviceimpls.CompanyServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request) {
		System.out.println(3);
		super.setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		super.execute();
		this.execute();
	}
	@Override
	public void execute() {
		EmployeeBean emp = new EmployeeBean();
		emp.setEmpNo(request.getParameter("empNo"));
		emp.setEname(request.getParameter("ename"));
		emp.setDeptNo(request.getParameter("deptNo"));
		emp.setComm(request.getParameter("comm"));
		emp.setHireDate(request.getParameter("hireDate"));
		emp.setJob(request.getParameter("job"));
		emp.setMgr(request.getParameter("mgr"));
		emp.setSal(request.getParameter("sal"));
		
		if(CompanyServiceImpl.getInstance().join(emp)) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}
}
