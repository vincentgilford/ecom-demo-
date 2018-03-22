package org.wecancodeit.ecom.catalog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceController {
	
	
	private CrudRepository<Product, Long> productRepo; 
		
	
	@RequestMapping(path = "/products", method= RequestMethod.POST) 
	//created method to help distinguish between contorllers see Browswe controller for different method
	public Product createProduct(Product incoming) {
		// TODO Auto-generated method stub
		return productRepo.save(incoming);
	}


}
