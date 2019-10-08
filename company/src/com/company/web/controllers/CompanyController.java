package com.company.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.web.command.Receiver;
import com.company.web.command.Sender;
import com.company.web.enums.Actions;
import com.sun.org.apache.regexp.internal.RE;

@WebServlet("/company.do")
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("company들어옴");
		Receiver.init(request);
		switch (Actions.valueOf(request.getParameter("action").toUpperCase())) {
		case CREATE: request.setAttribute("page","login");
		case LOGIN :  request.setAttribute("page","mypage");
			break;

		}
		Sender.forward(request, response);
		
		
	}


}
