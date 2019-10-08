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

import pojoBeans.Customer;

@WebServlet(name = "CreateEntity", urlPatterns = { "/CreateEntityval" })
public class CreateEntity extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {

		System.out.println("great recieved");
		  DatastoreService ds=DatastoreServiceFactory.getDatastoreService(); 
		  String fname="";
		  String lname="";
		  String city="";
		  String phn_number="";
		if(request.getParameter("fname")!=null && !"".equalsIgnoreCase(request.getParameter("fname")))
		{
		  fname=request.getParameter("fname");
		}else
		{
			fname="Empty firstname";
		}
		
		if(request.getParameter("lname")!=null && !"".equalsIgnoreCase(request.getParameter("lname")))
		{
			lname=request.getParameter("lname");
		}
		else
		{
			lname="empty lastname";
		}
		
		if(request.getParameter("city")!=null && !"".equalsIgnoreCase(request.getParameter("city")))
		{
			city=request.getParameter("city");
		}
		else
		{
			city="empty city";
		}
		
		if(request.getParameter("phn_nmbr")!=null && !"".equalsIgnoreCase(request.getParameter("phn_nmbr")))
		{
			phn_number=request.getParameter("phn_nmbr");
		}
		else
		{
			phn_number="000000000";
		}
		 
		
		 char c1=fname.charAt(0);
		 char c2=lname.charAt(0);
		 char c3=city.charAt(0);
		 char c4=phn_number.charAt(0);
		 char[] clist={c1,c2,c3,c4,c1,c3,c4};
		 
		String cust_ID=String.valueOf(clist);
		  Entity e=new Entity("Customer_Details");
		  e.setProperty("CustomerId",cust_ID); 
		  
		e.setProperty("First_Name", fname/* .concat(Integer.toString(2)).concat("Yes") */); 
		e.setProperty("Last_Name", lname/* .concat(Integer.toString(2)).concat("Yes") */); 
		  e.setProperty("Contact_Number", phn_number);
		  
		e.setProperty("City", city/* .concat(Integer.toString(2)).concat("Yes") */); 
		  ds.put(e);
		 
		 

		System.out.println("entered create Entity");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("message", "Customer Successfully Created with CustomerID : "+cust_ID);

		RequestDispatcher rd = request.getRequestDispatcher("/createCustomer.jsp");
		rd.forward(request, response);
	}
}