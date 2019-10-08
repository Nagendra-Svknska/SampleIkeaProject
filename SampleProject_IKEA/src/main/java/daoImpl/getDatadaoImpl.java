package daoImpl;

import java.util.ArrayList;
import java.util.List;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

import dao.getDataDao;
import pojoBeans.Customer;

public class getDatadaoImpl implements getDataDao {

	@Override
	public List<Customer> getdata() 
	{
		System.out.println("entered the getdata method ");
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		/* ArrayList cusList=new ArrayList (); */
		List<Customer>cusList=new ArrayList<Customer>();
		Query q= new Query("Customer_Details");
		PreparedQuery pq = ds.prepare(q);
		System.out.println(pq);
		Customer cus=new Customer();
		for(Entity e1:pq.asIterable()) 
		{
			 cus=new Customer();
			 
			 cus.setfName((e1.getProperty("First_Name").toString()));
			 cus.setlName((e1.getProperty("Last_Name").toString()));
			 cus.setCntctNumber((e1.getProperty("Contact_Number").toString()));
			 cus.setCity(e1.getProperty("City").toString());
			 cus.setCustomerId(e1.getProperty("CustomerId").toString());
			/* cus.setCustomerId(e1.getProperty("Key").toString()); */ /* not working */
			 cusList.add(cus);
		}
		return cusList;
	}

	@Override
	public Customer getCustDatabyID(String ID_val) 
	{
		System.out.println("entered the getCustData method ");
		 DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 Customer cus=new Customer();
		 List<Customer> cusList=new ArrayList<Customer>();
		 Query q= new Query("Customer_Details").addFilter("CustomerId", FilterOperator.EQUAL, ID_val);
		 PreparedQuery pq = ds.prepare(q);
		 for(Entity e1:pq.asIterable()) {
			 cus.setfName((e1.getProperty("First_Name").toString()));
			 cus.setlName((e1.getProperty("Last_Name").toString()));
			 cus.setCntctNumber((e1.getProperty("Contact_Number").toString()));
			 cus.setCity(e1.getProperty("City").toString());
			 cus.setCustomerId(e1.getProperty("CustomerId").toString());
		}
		 return cus;
 }

	@Override
	public Long gethighestCustID() 
	{
		
		return null;
	}
	
	
}
