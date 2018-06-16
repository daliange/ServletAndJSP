<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="left">Beer Recommendations JSP</h1>
	<p>
		<%
			ArrayList list = (ArrayList)request.getAttribute("list");
			Iterator it = list.iterator();
			while (it.hasNext()) {
				out.print("<br>JSP页面打印" + it.next());
			}
		%>
	
</body>
</html>