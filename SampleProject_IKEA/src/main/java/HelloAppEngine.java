import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@WebServlet(name = "HelloAppEngine", urlPatterns = {"/hello"})
public class HelloAppEngine extends HttpServlet 
{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException 
	{

		System.out.println("entered HelloAppEngine");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/secondPage.jsp");
		
			rd.forward(request, response);
	}
}