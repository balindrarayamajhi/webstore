package com.packt.webstore.services;
import java.util.List;
import com.packt.webstore.domain.Customers;
import com.packt.webstore.domain.Product;


public interface CustomerService {
	public List <Customers> getAllCustomers();
	
	public void addCustomer(Customers customer);
}
