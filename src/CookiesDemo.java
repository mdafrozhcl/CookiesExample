import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class CookiesDemo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String userrole=request.getParameter("userrole");
		Cookie c = new Cookie("user", username);
		Cookie c1= new Cookie("role", userrole);
		response.addCookie(c);
		response.addCookie(c1);
		request.getRequestDispatcher("/RedirectTo").forward(request, response);	
		//response.sendRedirect("/CookiesExample/RedirectTo");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
}
