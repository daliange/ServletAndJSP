package com.lijie.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{
	
	public void contextInitialized(ServletContextEvent sce) {
		//MyListener初始化
		System.out.println("MyListener初始化");
		ServletContext sc = sce.getServletContext();
		String encode = sc.getInitParameter("encode");
		System.out.println("MyListener启动时获取web.xml的encode="+encode);
		sc.setAttribute("listen", "listen-value");
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		//MyListener销毁
		System.out.println("MyListener销毁");
		ServletContext sc = sce.getServletContext();
		sc.removeAttribute("listen");
	}

}
