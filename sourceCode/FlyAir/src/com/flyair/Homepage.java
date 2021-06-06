package com.flyair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<BookedAirline> bookedAirline=new ArrayList<>();
//	String b=null;
//	String c=null;
//	int id=0;
//	int a1=0;
//	int a2=0;
	int passengertCount=0;
	static int price=0;
	static String airline=null;
	static String date=null;
	static int flightId=0;
	
	

	
	public Homepage() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				try {
					
				// read the "command" parameter
				String theCommand = request.getParameter("command");
				

				
				
				// route to the appropriate method
				switch (theCommand) {
				
					
				case "LOAD":
					loadAirline(request, response);
					break;
					

								
				default:
					doPost(request, response);
					break;
				}
//				//read the name from the registered3.jsp
//				String name=request.getParameter("uname");
//				request.setAttribute("PassengerName",name);
//				request.setAttribute("Name",airline);
//				request.setAttribute("FlightID",flightId);
//				request.setAttribute("Date",date);
//				request.setAttribute("Ticketprice",price);
//				RequestDispatcher dispatcher=request.getRequestDispatcher("payment.jsp");
//				dispatcher.forward(request, response);
//			
					
			}
				
				
			catch (Exception exc) {
				throw new ServletException(exc);
			}




	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String source = request.getParameter("From");
		String destination = request.getParameter("Destiantion");
		String date = request.getParameter("date");
		String pNumber = request.getParameter("number");
		int passengerNumber = Integer.parseInt(pNumber);

		passengertCount=passengerNumber;
	
		

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			List<SourceDestination> list = session.createQuery("from SourceDestination").list();
			List<Flight> flightList = session.createQuery("from Flight").list();
			List<Airline> airlineList = session.createQuery("from Airline").list(); 
			

			for (SourceDestination p : list) {

				if (source.equals(p.getFrom()) && destination.equals(p.getDestination())) {
					
					for (Flight f : flightList) {
						
						if (p.getID() == f.getFlightID() && date.equals(f.getDate())) {
							
							int totalrice= passengerNumber * f.getSingleTicketPrice();

							for (Airline a : airlineList) {
								if (f.getAirlineID() == (a.getID())) {

									bookedAirline.add(new BookedAirline(f.getId(),a.getAirline(),totalrice,f.getDate()));

								}
							}


						}
					}

				}

			}

			session.close();
			
			
				//set request object
			request.setAttribute("airlines", bookedAirline);
			//set RequesrDispatcher
			RequestDispatcher dispatcher=request.getRequestDispatcher("registered.jsp");
			
		   // forwardRequesrDispatcher
			dispatcher.forward(request, response);



		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private void loadAirline(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException{
		
		//read the airline name form the jsp data
		String flightID=request.getParameter("airline");
		int id=Integer.parseInt(flightID);
		System.out.println(id);

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			List<Flight> flightList = session.createQuery("from Flight").list();
			List<Airline> airlineList = session.createQuery("from Airline").list(); 
			session.close();
			for (Flight f : flightList) {
		if(id==(f.getId())) {
	
			for (Airline a : airlineList) {
				
				if(f.getAirlineID()==a.getID()) {
					
					 price=passengertCount*f.getSingleTicketPrice();
					airline=a.getAirline();
					date=f.getDate();
					
					request.setAttribute("Name",airline);
					flightId=f.getId();
					System.out.println(a.getAirline());
					request.setAttribute("FlightID",flightId);
					request.setAttribute("Date",date);
					request.setAttribute("Ticketprice",price);
					RequestDispatcher dispatcher=request.getRequestDispatcher("registered3.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		}
		
	}	

	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}


	public static int getPrice() {
		return price;
	}

	public  void setPrice(int price) {
		Homepage.price = price;
	}

	public int getPassengertCount() {
		return passengertCount;
	}

	public void setPassengertCount(int passengertCount) {
		this.passengertCount = passengertCount;
	}

	public static String getAirline() {
		return airline;
	}

	public static void setAirline(String airline) {
		Homepage.airline = airline;
	}

	public static String getDate() {
		return date;
	}

	public static void setDate(String date) {
		Homepage.date = date;
	}

	public static int getFlightId() {
		return flightId;
	}

	public static void setFlightId(int flightId) {
		Homepage.flightId = flightId;
	}
	

}
