package com.flyair;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String airline =null; 
	String Date =null;
	int FlightID =0;
	int Ticketprice= 0;
	String name=null;
	
    public Registration() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		out.println("<html><body>");
		if(request.getParameter("Payment").equals("pay")){
			out.println(name+" You have booked Ticket!");
			out.println(" You have selected airline :"+airline);
			out.println(" Flight ID:"+FlightID);
			out.println("Date of travel:"+Date);
			
		}
		
		
		out.println("</body></html>");


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		name=request.getParameter("uname");
		String lastname=request.getParameter("lname");
		String passport=request.getParameter("nid");
		String country=request.getParameter("country");
		String Bday=request.getParameter("birthday");
		
		
		
//		PrintWriter out=response.getWriter();
//		out.println("<html><body>");
		
		
		 airline =Homepage.getAirline(); 
		 Date =Homepage.getDate();
		 FlightID =Homepage.getFlightId();
		 Ticketprice= Homepage.getPrice();
		
		
		// getting values from HomePage servlet
		
		request.setAttribute("airline", airline);
		request.setAttribute("Ticketprice", Ticketprice);
		request.setAttribute("FlightID", FlightID);
		request.setAttribute("Date", Date);
		
		
		

		request.setAttribute("name", name);
		request.setAttribute("lastname", lastname);
		request.setAttribute("passport", passport);
		request.setAttribute("country", country);
		request.setAttribute("Bday", Bday);
		RequestDispatcher dispatcher=request.getRequestDispatcher("payment.jsp");
		dispatcher.forward(request, response);
		

	}

}
