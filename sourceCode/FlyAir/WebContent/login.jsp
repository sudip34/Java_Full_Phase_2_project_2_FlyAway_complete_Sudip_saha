<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	String uname=request.getParameter("uname");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	String age=request.getParameter("age");
	
	if(uname==null||uname.equals("")||password==null||password.equals(""))
	{
		response.sendRedirect("admin.jsp?error=1");
	}else{
		session.setAttribute("name",uname);response.sendRedirect("logoutDashboard.jsp");
		
	}


%>