package com.packt.webstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customers;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerrepository;
	
	
	@Override
	public List<Customers> getAllCustomers() {
		
		return customerrepository.getAllCustomers();
	}


	@Override
	public void addCustomer(Customers customer) {
		customerrepository.addCustomer(customer);
		
	}

}
