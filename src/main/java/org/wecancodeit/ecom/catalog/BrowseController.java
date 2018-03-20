package org.wecancodeit.ecom.catalog;

import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestController
public class BrowseController {
	
	@RequestMapping("/products")
	public Collection<Product> getProducts() {
		
		return Collections.singleton(new Product());
	}
	
	
	

	
	
	
		
}
