package com.company.web.command;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		System.out.println(1);
		cmd = Commander.order(request);
	}
}
