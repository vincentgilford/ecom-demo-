package org.wecancodeit.ecom.catalog;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@Resource//required for injection from Spring
	private CrudRepository<Product,Long> productRepo; 
	
	//500 - server error THINK Controller
	//400 means that USER requested something incorrectly
	
	@RequestMapping("/products")
	public Iterable<Product> findProducts() {
		return productRepo.findAll();
	}
	@RequestMapping("/products/{id}")
	public Product findProduct(@PathVariable(name="id")Long id) {
		// TODO Auto-generated method stub
		Product selectedProduct = productRepo.findOne(id); 
		if(selectedProduct != null) {
			return selectedProduct; 
		}
		
			return productRepo.findOne(id);  
	}
	
	//expected to get an error at a higher level where ids do not exists
	//controller needs to indicate that doesn't exist
	//---> simple solution is throw an exception
	//------>
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ProdcutNotFoundException extends RuntimeException{

	}

}