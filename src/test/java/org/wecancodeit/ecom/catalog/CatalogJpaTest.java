package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.ecom.catalog.Product;
import org.wecancodeit.ecom.catalog.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CatalogJpaTest {

		@Resource 
		private ProductRepository productRepo; 
	
		@Test
		public void shouldFoo() {
			//test to make sure it is a CRUDrepository -- will have to extend crud when we eventually
			// do more specific things with the our productrepository
			
		}
		
		@Test
		public void shouldASsignIdWhenProductIsCreated() {
			Product product = new Product("my new product"); 
			
			product = productRepo.save(product);
			
		}
		
		
}
