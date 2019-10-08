package com.company.web.command;

import javax.servlet.http.HttpServletRequest;

import com.company.web.pool.Constants;

import lombok.Data;
@Data

public class Command implements Order{
	protected HttpServletRequest request;
	protected String action,domain,page,view;
	
	
	
	@Override
	public void execute() {
		System.out.println(4);
		this.view = String.format(Constants.DOUBLE_PATH,"facade","main");
		
	}

}
