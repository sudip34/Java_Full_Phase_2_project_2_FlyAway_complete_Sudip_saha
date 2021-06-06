<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<%
if (request.getParameter("error")!=null)//Error flag is 1 or 0
		out.println("<br> Entered infomation doesn't match properly! please try agin");
%>

<form action="Admin" method="post">
	<table>
	
		<tr><td>User Name:</td><td><input type="text" name="uname"></td></tr>
		<tr><td>User Password:</td><td><input type="password" name="password"></td></tr>
		<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
		<tr><td>Age:</td><td><input type="text" name="age"></td></tr>
		<tr><td></td><td><input type="submit" name="submit"></td></tr>
		
	
	</table>
</form>
</body>
</html>