package com.packt.webstore.domain;

import java.io.Serializable;

public class Customers implements Serializable {

	private static final long serialVersionUID = 519120743943282354L;
	private String customerId;
	private String  name; 
	private String address;
	private Long noOfOrdersMade;
	
	public Customers(String customerId, String name, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((noOfOrdersMade == null) ? 0 : noOfOrdersMade.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfOrdersMade == null) {
			if (other.noOfOrdersMade != null)
				return false;
		} else if (!noOfOrdersMade.equals(other.noOfOrdersMade))
			return false;
		return true;
	}
	public void setNoOfOrdersMade(Long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

}
