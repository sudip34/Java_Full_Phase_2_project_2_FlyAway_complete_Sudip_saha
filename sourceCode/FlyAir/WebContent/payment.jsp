<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


Hello! <%= request.getAttribute("name")%> 
. You have selected airline :<%= request.getAttribute("airline")%> 
  Flight ID:<%= request.getAttribute("FlightID")%> |
  Travel Date:<%= request.getAttribute("Date")%>  |
  Ticket price:<%= request.getAttribute("Ticketprice")%>
  
  
  

 <form action="Registration" method="GET">
	<table>
	
		<tr><td>From
			<select name="Payment">
				<option>0</option>
				<option>pay</option>
				
			</select>
			<br/><br/>
			</td></tr> 
		<tr><td></td><td><input type="submit" name="payment" ></td></tr>
		
		
	
	</table>
</form>
</body>
</html>