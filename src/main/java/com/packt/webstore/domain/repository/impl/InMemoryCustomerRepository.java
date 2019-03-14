package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customers;

import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	@Autowired 
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public List<Customers> getAllCustomers() {
		Map<String, Object> params = new HashMap<String, Object>(); 
		List<Customers> result = jdbcTemplate.query("SELECT * FROM customers", params, new CustomerMapper()); 

		return result;

	}

	private static final class CustomerMapper implements RowMapper<Customers> {

		public Customers mapRow(ResultSet rs, int rowNum) throws SQLException { 

			Customers customer = new Customers(); 
			
			customer.setCustomerId(rs.getString("ID"));
			customer.setName(rs.getNString("NAME"));
			customer.setAddress(rs.getNString("ADDRESS"));
			customer.setNoOfOrdersMade(rs.getLong("NO_OF_ORDER_MADE"));


			return customer; 
		}
	}

	@Override
	public void addCustomer(Customers customer) {
		String SQL="INSERT INTO CUSTOMERS (" 
											+"ID, "
											+"NAME, "
											+"ADDRESS, " 
											+"NO_OF_ORDER_MADE)"
											+"VALUES( :id, :name, :address, :noOfOrderMade)";
		
		Map<String,Object> params=new HashMap<>();
		params.put("id", customer.getCustomerId());
		params.put("name", customer.getName());
		params.put("address", customer.getAddress());
		params.put("noOfOrderMade", customer.getNoOfOrdersMade());
		
		jdbcTemplate.update(SQL, params);
											
	}



}


