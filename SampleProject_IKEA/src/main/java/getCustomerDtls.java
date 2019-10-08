import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daoImpl.getDatadaoImpl;
import pojoBeans.Customer;

@WebServlet(name = "getCustomerDtls", urlPatterns = { "/getCustomerDtls" })
public class getCustomerDtls extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Customer>custList=new ArrayList<Customer>();
		System.out.println("entered getCustomerDtls");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		getDatadaoImpl gt = new getDatadaoImpl();
		System.out.println("getdatdaoimpl");
		/* Long iD_val=Long.parseLong(request.getParameter("customerID_val")); */
		String custID=request.getParameter("customerID_val").toString();
		Customer ct=gt.getCustDatabyID(custID);
		custList.add(ct);
		System.out.println(ct.getCity());
		request.setAttribute("Customer_List", custList);
		RequestDispatcher rd = request.getRequestDispatcher("/customerFullDetails.jsp");
		rd.forward(request, response);
	}
}