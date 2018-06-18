<!-- jsp指令 -->
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="com.lijie.common.*"%>
<html>
<body>
	<h2>Hello World!</h2>
	<h2>你好!</h2>
	
	<br>java代码
	<!-- java代码 -->
	<%
		out.println("111");
		out.println(Counter.getCount());
	%>
	
	<br>jsp表达式
	<!-- jsp表达式 -->
	<%= Counter.getCount() %>
	
	<br>jsp声明
	<!-- jsp声明 -->
	<%! int i =1; %>
	<%= i++ %>
	
	<%-- jsp注释，不会返回给客户端 --%>
	
	<br>获取jsp初始化参数
	<!-- 获取jsp的初始化参数 -->
	<!-- jsp声明 -->
	<%! 
	public void jspInit(){
		ServletConfig sc = getServletConfig();
		String name = sc.getInitParameter("name");
		ServletContext servletcontext = sc.getServletContext();
		servletcontext.setAttribute("name", name);
	}
	%>
	<br>
	<%= application.getAttribute("name") %>
	<br>request获取ServletConfig
	<br>
	<%= this.getServletConfig().getInitParameter("name") %>
	
	
	
	
	
	
	
</body>
</html>
