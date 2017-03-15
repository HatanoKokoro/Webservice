package com.service;

public class MyWebservice {
	
	public String getName(String name){
		return "我叫："+name;
	}
	
	public void print(String out){
		System.out.println("输出："+out);
	}
	
	public boolean login(String user,String password){
		boolean validate=false;
		if(user.equals("Artoria")&& password.equals("123456")){
			validate = true;
		}
		return validate; 
	}

}
