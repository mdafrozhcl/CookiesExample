import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class DBPortal extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameter("role").equals("DBAdmin")){
			response.sendRedirect("/CookiesExample/RedirectTo");
		}
		PrintWriter out=response.getWriter();
		out.println("<table align=center cellpadding=10><tr>"
				+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Admin Portal</a></th>"
				+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Emp Portal</a></th>"
				+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Database Portal</a></th>"
				+ "</tr></table>");
		out.println("<h3 align=center>Hi Database Admin You can see only this page.</h3>Click <a href=\"/CookiesExample/users.html\">here</a> to signin again.");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
