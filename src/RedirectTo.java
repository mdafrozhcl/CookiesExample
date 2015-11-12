import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class RedirectTo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userrole = "";
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();

		for (Cookie c : cookies) {
			if ("role".equals(c.getName()))
				userrole = c.getValue();
		}
		switch (userrole.toString()) {
		case "Admin":
			request.getRequestDispatcher("/EmpPortal?role=Admin").forward(
					request, response);

			// response.sendRedirect("/CookiesExample/EmpPortal?role=Admin");
			break;
		case "DBAdmin":
			request.getRequestDispatcher("/EmpPortal?role=DBAdmin").forward(
					request, response);
			break;
		case "Employee":
			request.getRequestDispatcher("/EmpPortal?role=Employee").forward(
					request, response);
			break;
		default:
			out.println("<table align=center cellpadding=10><tr>"
					+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Admin Portal</a></th>"
					+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Emp Portal</a></th>"
					+ "<th><a href=\"/CookiesExample/RedirectTo\" style=\"text-decoration: none;\">Database Portal</a></th>"
					+ "</tr></table>");
			out.println("<h3 align=center>You have no permissions senior.</h3>Click <a href=\"/CookiesExample/users.html\">here</a> to signin again.");
			break;
		}
	}

}
