package dao;

import com.google.api.services.discovery.Discovery.Apis.List;

import pojoBeans.Customer;

public interface getDataDao 
{
	public java.util.List<Customer> getdata();
	public Customer getCustDatabyID(String Id);
	public Long gethighestCustID();

}
