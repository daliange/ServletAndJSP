package com.lijie.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		
		//HttpSession第一次获取会创建一个session，后面再次访问，获得已经创建的
		HttpSession session = request.getSession();
		if(session.isNew()){
			System.out.println("------第一次创建session");
		}else{
			System.out.println("------获取已有的session");
		}
		
		//获取ServletConfig的参数
		System.out.println("从web.xml中获取ServletConfig的参数,name="+name);
		
		//获取ServletContext上下文中的参数
		String encode = getServletContext().getInitParameter("encode");
		System.out.println("从web.xml中获取ServletContext上下文中的参数,encode="+encode);
		
		//获取ServletContext上下文中的参数，容器启动时Listener加载的
		String listen = (String)getServletContext().getAttribute("listen");
		System.out.println("容器启动时Listener加载的,获取ServletContext上的参数,listen="+listen);
		
		//针对URL重写（针对客户端禁用Cookie的情况）,容器如何知道需要encode？？？
		String encodeURL = response.encodeURL("return.jsp");
		System.out.println("encodeURL="+encodeURL);
		
		String encodeRedirectURL = response.encodeRedirectURL("return.jsp");
		System.out.println("encodeRedirectURL="+encodeRedirectURL);
		
		//返回一个文件
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
