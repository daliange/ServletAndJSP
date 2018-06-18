<!-- jsp指令 -->
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="com.lijie.common.*"%>
<html>
<body>
	<h2>Hello World!</h2>
	<h2>你好!</h2>
	
	<!-- java代码 -->
	<%
		out.println("111");
		out.println(Counter.getCount());
	%>
	<!-- jsp表达式 -->
	<%= Counter.getCount() %>
	
	<!-- jsp声明 -->
	<%! int i =1; %>
	<%= i++ %>
	
	<%-- jsp注释，不会返回给客户端 --%>
	
</body>
</html>
