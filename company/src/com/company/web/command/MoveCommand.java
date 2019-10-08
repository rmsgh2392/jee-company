package com.company.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) {
		super.setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
	}
	
	@Override
	public void execute() {
		request.setAttribute("page",request.getParameter("page"));
		super.execute();
	}
}
