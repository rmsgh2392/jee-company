package com.company.web.command;
import javax.servlet.http.HttpServletRequest;
import com.company.web.domains.EmployeeBean;
import com.company.web.pool.Constants;
import com.company.web.serviceimpls.CompanyServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		super.setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		EmployeeBean emp = new EmployeeBean();
		emp.setDeptNo(request.getParameter("deptNo"));
		emp.setEmpNo(request.getParameter("empNo"));
		emp.setEname(request.getParameter("ename"));
		emp = CompanyServiceImpl.getInstance().login(emp);
		if(emp!=null) {
			System.out.println("로그인성공");
			setPage(request.getParameter("page"));
			request.setAttribute("employee", emp);
		}else {
			System.out.println("실패");
		}
		super.execute();
	}
}
