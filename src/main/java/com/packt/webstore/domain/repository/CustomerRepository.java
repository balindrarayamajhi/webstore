package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Customers;

public interface CustomerRepository {
	public List <Customers> getAllCustomers();
	
	public void addCustomer(Customers customer);

}
