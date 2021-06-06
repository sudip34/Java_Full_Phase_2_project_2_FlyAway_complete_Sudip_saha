<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>



<form action="Homepage" method="post">
	<table>
	
		<tr><td>From
			<select name="From">
				<option>Berlin</option>
				<option>New York</option>
				<option>Paris</option>
			</select>
			<br/><br/>
			</td></tr> 
			
		<tr><td>Destination
		<select name="Destiantion">
			<option>Berlin</option>
			<option>London</option>
			<option>Madrid</option>
			<option>Milan</option>
			<option>New York</option>
			<option>New Delhi</option>
			<option>Paris</option>
		</select>
		<br/><br/>
		</td></tr> 
		
		<tr><td>Date:[format:YYYY-MM-DD]</td><td><input type="date" name="date"></td></tr>
		<tr><td>Number of Passengers</td><td><input type="number" name="number"></td></tr>
		
		
		<tr><td></td><td><input type="submit" name="submit"></td></tr>
		
		
	
	</table>
</form>
</body>
</html>