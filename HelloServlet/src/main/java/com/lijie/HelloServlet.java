package com.lijie;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		System.out.println("doGet--------");
		String name = request.getParameter("name");
		System.out.println("name="+name);
		//获取request请求的值
		try {
			Writer  writer = response.getWriter();
			writer.write("Writer print！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("doGet--------");
	}

}
