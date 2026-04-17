package mini_project;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class DisplayRecord extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieving all records from Student table using Hibernate
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = sf.openSession();

        Query q = session.createQuery("from Student");

        List resultList = q.getResultList();

        // Storing data in session
        HttpSession hs = request.getSession(true);
        hs.setAttribute("student", resultList);

        // Redirect to display JSP page
        response.sendRedirect("/StdManagementSystemProject/disp.jsp");
    }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
