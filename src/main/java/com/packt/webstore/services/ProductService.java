package com.packt.webstore.services;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Product;

public interface ProductService {
	public void updateAllStocks();
	
	public List<Product> getAllProducts();
	
	public List<Product> getProductsByCategory(String category);
	
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	public Product getProductById(String productID);
	
	public void addProduct(Product product);
}
