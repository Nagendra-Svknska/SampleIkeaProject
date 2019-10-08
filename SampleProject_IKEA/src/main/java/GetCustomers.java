import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daoImpl.getDatadaoImpl;
import pojoBeans.Customer;

@WebServlet(name = "GetCustomers", urlPatterns = { "/getCustomers" })
public class GetCustomers extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("entered GetCustomers");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		getDatadaoImpl gt = new getDatadaoImpl();
		System.out.println("getdatdaoimpl");
		/*
		 * Long iD_val=Long.parseLong("1"); Customer ct=gt.getCustDatabyID(iD_val);
		 */
		
		  List<Customer>cust_list=gt.getdata(); 
		  System.out.println(cust_list.size());
		
		  for(Customer cust:cust_list) { System.out.println(cust.getCity()); }
		 
		
		/* System.out.println(ct.getCity()); */
		RequestDispatcher rd = request.getRequestDispatcher("/customerDetails2.jsp");
		request.setAttribute("Customer_List", cust_list);

		rd.forward(request, response);
	}
}