package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.Customers;
import com.packt.webstore.services.CustomerService;

@Controller
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers") 
	public String list(Model model) {  
		
		model.addAttribute("customers", customerService.getAllCustomers()); 
		
		return "customers";
	}
	
	@RequestMapping(value="/customers/add", method = RequestMethod.GET)
	public String addNewCustomerForm(@ModelAttribute("newCustomer")Customers customer) {
		return "addCustomer";
	}
	
	@RequestMapping(value="/customers/add",  method = RequestMethod.POST)
	public String processNewCustomerForm(@ModelAttribute("newCustomer")Customers customer) {
		customerService.addCustomer(customer);
		return "redirect:/customers";
	}
	
}

