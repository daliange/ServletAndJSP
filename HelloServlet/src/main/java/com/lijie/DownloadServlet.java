package com.lijie;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadServlet extends HttpServlet {
	
	private String name;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.name = config.getInitParameter("name");
		System.out.println("web容器启动时未调用init方法，该方法第一次被调用时，name="+name);
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("application/jar");
		response.setContentType("text/html");
		
		//获取ServletConfig的参数
		System.out.println("从web.xml中获取ServletConfig的参数,name="+name);
		
		//获取ServletContext上下文中的参数
		String encode = getServletContext().getInitParameter("encode");
		System.out.println("从web.xml中获取ServletContext上下文中的参数,encode="+encode);
		
		//获取ServletContext上下文中的参数，容器启动时Listener加载的
		String listen = (String)getServletContext().getAttribute("listen");
		System.out.println("容器启动时Listener加载的,获取ServletContext上的参数,listen="+listen);
		
		
		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream("/download.txt");
		
		OutputStream os = response.getOutputStream();
		
		int read = 0;
		byte[] bytes = new byte[1024];
		
		while((read=is.read(bytes))!=-1){
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
	}

}
