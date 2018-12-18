package com.felix.web;

import com.felix.domain.User;
import com.felix.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	
	private UserService userservice;
	
	public String user() throws Exception {
		User user = userservice.getUser();
		System.out.println("随便写个action");
		return SUCCESS;
	}
	

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	
}
