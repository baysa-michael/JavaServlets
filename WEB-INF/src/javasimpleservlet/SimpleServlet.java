// Save Destination:  "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\javaservlets\WEB-INF\src\SimpleServlet.java"
package javasimpleservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
		// Set Response Message Type
		response.setContentType("text/html;charset=UTF-8");
		
		// Allocate an Output Writer to write message into network socket
		PrintWriter out = response.getWriter();
		
		// Write the message in an HTML page
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Simple Servlets</title>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Simple Servlet Output</h1>");
			out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
			out.println("<p>Request Protocol: " + request.getProtocol() + "</p>");
			out.println("<p>Path Info: " + request.getPathInfo() + "</p>");
			out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
			out.println("<p>Prepared By:  Michael Baysa</p>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}