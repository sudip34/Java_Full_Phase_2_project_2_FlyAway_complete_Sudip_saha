package com.flyair;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Update() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<User> alluser = null;
		
		
		User u=null;
		
		try {

			String userName = request.getParameter("uname");

			String oldPwd = request.getParameter("password");
			String email = request.getParameter("email");
			String newPwd = request.getParameter("new_password");
			String newPwdCheck = request.getParameter("new_password_checked");

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>User</b><br>");
			alluser=session.createQuery("from User").list();
			
			for(User user: alluser) {
			out.println(user.getFirstName());
			
			
				
				if (userName.equals(user.getFirstName()) && email.equals(user.getEmail()) && oldPwd.equals(user.getPassword())) {
					System.out.println("now to check new password");

					if (newPwd != null && (!newPwd.equals("")) && (newPwd.equals(newPwdCheck))) {
						// Save the passenger in database
						Transaction tx = session.beginTransaction();
						
						// get the user object
						u=session.get(User.class, user.getId());
						// update password in database
						u.setPassword(newPwd);
						session.saveOrUpdate(user);
						

						tx.commit();
						
						out.println("Successfully data updated in database");
						out.println("<a href=\"http://localhost:10524/FlyAir/logoutDashboard.jsp\">Logout</a>");
						

					} else {
						

						response.sendRedirect("updateLoginData.jsp?error=1");

					}

				}
			 
			

			out.println("</body></html>");
			
			}
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
