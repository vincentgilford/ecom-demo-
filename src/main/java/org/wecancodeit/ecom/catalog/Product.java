package org.wecancodeit.ecom.catalog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	private String name; 
	
	
	
	public long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public Product(String name) {
		this.name = name;
		
	}

	private Product() {}; 

	private Collection<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
