<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airline Booking App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Airline Ticket Booking</h2>
		</div>
		
		
		
	</div>
	
	
	<div id="container">
		<div id="content">
		<!-- put new button: Admin -->
					<input type="button" value="Admin"
					onclick="window.location.href='admin.jsp'; return false;"
					class="Admin-button"
					/>
		<table>
			<tr>
			    <th>Flight ID</th>
				<th>Airline Name</th>
				<th>Ticket price</th>
				<th>Date/Time</th>
				<th>Action</th>
				
				
						
				<c:forEach var="name" items="${airlines}">
				
				<!-- set up link for each airline -->
				<c:url var="tempLink" value="Homepage">
					<c:param name="command" value="LOAD"/>
					<c:param name="airline" value="${name.id}"/>				
				</c:url>
				
				
				<tr>
				    <td>${name.id}</td>
					<td>${name.airlineName}</td>
					<td>${name.price}</td>
					<td>${name.date}</td>
					<td> <a href="${tempLink}">Select</a> </td>
					
					
				</tr>
				
				
				</c:forEach>
			</tr>
		</table>
		
		</div>
	</div>


       ${name}<br/>



</body>
</html>