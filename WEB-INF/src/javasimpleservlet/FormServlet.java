// Save Destination:  "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\javaservlets\WEB-INF\src\FormServlet.java"
package javasimpleservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
		// Set Response Message Type
		response.setContentType("text/html;charset=UTF-8");
		
		// Allocate an Output Writer to write message into network socket
		PrintWriter out = response.getWriter();
		
		// Retrieve the Response Values
		String username = request.getParameter("username");
		int userage = Integer.parseInt(request.getParameter("userage"));
		String useremail = request.getParameter("useremail");
		String userjob = request.getParameter("userjob");
		float usersalary = Float.parseFloat(request.getParameter("usersalary"));
		
		// Get Retirement Salary
		float retirementsalary = getRetirementSalary(userage, usersalary);
		
		// Write the message in an HTML page
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Retirement Salary Servlet</title>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>CALCULATED RETIREMENT SALARY</h1>");
			out.println("<p>NAME: " + username + "</p>");
			out.println("<p>AGE: " + userage + "</p>");
			out.println("<p>E-MAIL: " + useremail + "</p>");
			out.println("<p>JOB: " + userjob + "</p>");
			out.printf("<p>CURRENT SALARY: %1$,.2f</p>", usersalary);
			out.printf("<p>SALARY AT RETIREMENT: %1$,.2f</p>", retirementsalary);
			out.println("<p>Prepared By:  Michael Baysa</p>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
		// Redirect Post Requests
		doGet(request, response);
	}
	
	public float getRetirementSalary(int age, float usersalary) {
		int yearsToRetirement = 65 - age;
		float averageSalaryGrowth = 0.03f;
		int compoundingPeriod = 1;
		
		return (float) (usersalary * Math.pow((1 + (averageSalaryGrowth / compoundingPeriod)), 
			(yearsToRetirement / compoundingPeriod)));
	}
}