package com.flyair;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Admin() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			String uname=request.getParameter("uname");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String age=request.getParameter("age");
			if(uname==null||uname.equals("")||password==null||password.equals(""))
			{
				response.sendRedirect("admin.jsp?error=1");
			}else{
				SessionFactory factory=HibernateUtil.getSessionFactory();
				 //create Session
					Session session=factory.openSession();
		            User user=new User();
		            if(uname.equalsIgnoreCase(user.getFirstName())&&password.equals(user.getPassword())) {
		            	 PrintWriter out=response.getWriter();
				            out.println("<html><body>");
				            out.println("!you are logedin Successfully!");
				            
				            out.println("<a href=\"http://localhost:10524/FlyAir/updateLoginData.jsp\">Update you Login information</a>\r\n" + 
				            		"");
				            out.println("</body></html>");
		            	
		            }else  {
		            user.setFirstName(uname);
		            user.setPassword(password);
		            user.setEmail(email);
		            user.setAge( Long.valueOf(age).longValue());
		          //Save the passenger in database
		            Transaction tx = session.beginTransaction();
		            session.save(user);
		            System.out.println("Successfully data insert in database");

		            tx.commit();
		            PrintWriter out=response.getWriter();
		            out.println("<html><body>");
		            out.println("!you are registered Successfully!");
		            
		            out.println("<a href=\"http://localhost:10524/FlyAir/updateLoginData.jsp\">Update you Login information</a>\r\n" + 
		            		"");
		            out.println("</body></html>");
  
				
			}
		            session.close();
			}
		
            
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
