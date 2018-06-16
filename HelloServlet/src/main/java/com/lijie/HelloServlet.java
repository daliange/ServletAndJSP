package com.lijie;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JEditorPane;

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
		//获取Cookie 
		Cookie[] listcookie = request.getCookies();
		for(int i=0 ;i< listcookie.length;i++){
			Cookie cookie = listcookie[i];
			System.out.println("----------------------------------");
			System.out.println("cookie.getName()="+cookie.getName());
			System.out.println("cookie.getValue()="+cookie.getValue());
			System.out.println("cookie.getMaxAge()="+cookie.getMaxAge());
		}
		//MaxAge=-1,默认值是-1，表示关闭浏览器，Cookie失效
		
		//创建一个集合
		ArrayList list = new ArrayList();
		list.add("name");
		list.add("age");
		list.add("high");
		
		response.setContentType("text/html");
		
		//返回Cookie，设置Cookie有效期
		Cookie cookiename = new Cookie("cookiename","lijie");
		Cookie cookiepassword = new Cookie("cookiepassword","870807");
		cookiename.setMaxAge(3600);
		response.addCookie(cookiename);
		response.addCookie(cookiepassword);
//		try {
//			Writer  writer = response.getWriter();
//			writer.write("Writer print！"+color);
//			Iterator it = list.iterator();
//			while(it.hasNext()){
//				writer.write("<br>"+(String)it.next());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		//请求转发
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("return.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
