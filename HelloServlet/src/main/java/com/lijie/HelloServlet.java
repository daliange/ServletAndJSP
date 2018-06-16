package com.lijie;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		System.out.println("doGet--------");
		String color = request.getParameter("color");
		System.out.println("color="+color);
		//获取request请求的值
		try {
			Writer  writer = response.getWriter();
			writer.write("Writer print！"+color);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doPost--------");
		String color = request.getParameter("color");
		System.out.println("color="+color);
		
		response.setContentType("text/html");
		try {
			Writer  writer = response.getWriter();
			writer.write("Writer print！"+color);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
