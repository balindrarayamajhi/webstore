DROP TABLE PRODUCTS IF EXISTS;

CREATE TABLE PRODUCTS (
	 ID VARCHAR(25) PRIMARY KEY,
	 NAME VARCHAR(50), 
	 DESCRIPTION VARCHAR(250), 
	 UNIT_PRICE DECIMAL, 
	 MANUFACTURER VARCHAR(50), 
	 CATEGORY VARCHAR(50), 
	 CONDITION VARCHAR(50), 
	 UNITS_IN_STOCK BIGINT, 
	 UNITS_IN_ORDER BIGINT, 
	 DISCONTINUED BOOLEAN
	  );

DROP TABLE CUSTOMERS IF EXISTS;	  
CREATE TABLE CUSTOMERS (
	 ID VARCHAR(25) PRIMARY KEY,
	 NAME VARCHAR(50), 
	 ADDRESS VARCHAR(250), 
	 NO_OF_ORDER_MADE BIGINT 
	  );
	  
	  
	  
DROP TABLE CART IF EXISTS;  
CREATE TABLE CART (
	   ID VARCHAR(50) PRIMARY KEY );

DROP TABLE CART_ITEM IF EXISTS;
CREATE TABLE CART_ITEM ( 
						ID VARCHAR(75) PRIMARY KEY, 
						PRODUCT_ID VARCHAR(25), 
						CART_ID VARCHAR(50), 
						QUANTITY BIGINT, 
						);