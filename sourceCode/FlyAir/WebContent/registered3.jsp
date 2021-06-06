<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<%
if (request.getParameter("error")!=null)//Error flag is 1 or 0
		out.println("<br> Entered infomation doesn't match properly! please try agin");
%>

<form action="Registration" method="post">
	<table>
	
		<tr><td>First Name:</td><td><input type="text" name="uname"></td></tr>
		<tr><td>Last Name:</td><td><input type="text" name="lname"></td></tr>
		<tr><td>Passport no.:</td><td><input type="text" name="nid"></td></tr>
		<tr><td>Country:</td><td><input type="text" name="country"></td></tr>
		<tr><td>Date of birth: [YY-MM-DD] </td><td><input type="text" name="birthday"></td></tr>
		<tr><td></td><td><input type="submit" name="submit"></td></tr>
		
	
	</table>
</form>

You have selected airline :<%= request.getAttribute("Name")%> 
Flight ID:<%= request.getAttribute("FlightID")%> 
Travel Date:<%= request.getAttribute("Date")%>
Ticket price:<%= request.getAttribute("Ticketprice")%>




			
</body>
</html>