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
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("application/jar");
		response.setContentType("text/html");
		System.out.println("从web.xml中获取的name="+name);
		
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
