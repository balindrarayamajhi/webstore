package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Product;

public interface ProductRepository {
	
	public List <Product> getAllProducts();

	public void updateStock(String productId, long noOfUnits);
	
	public List<Product> getProductsByCategory(String category);
	
	public  List<Product> getProductsByFilter(Map<String,List<String>> filterParams);
	
	public Product getProductById(String productID);
	
	public void addProduct(Product product);
}
