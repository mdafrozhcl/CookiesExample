

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpPortal extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameter("role").equals("Employee")||request.getParameter("role")==null){
			response.sendRedirect("/CookiesExample/RedirectTo");
		}
		PrintWriter out=response.getWriter();
		out.println("<table align=center cellpadding=10><tr>"
				+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Admin Portal</a></th>"
				+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Emp Portal</a></th>"
				+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Database Portal</a></th>"
				+ "</tr></table>");
		
		out.println("<h3 align=center>Hi Employee You can see only this page.</h3>Click <a href=\"/CookiesExample/users.html\">here</a> to signin again.");

	}


}
