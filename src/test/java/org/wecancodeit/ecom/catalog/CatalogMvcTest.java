package org.wecancodeit.ecom.catalog;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@RunWith(SpringRunner.class)
public class CatalogMvcTest {

		@Resource
		private MockMvc mvc; 
		
		
		@MockBean
		private CrudRepository<Product, Long> productRepo;
		// does what mock but injects bean into spring context i.e when browswer controller needs to be injected
		//required for browser controller --> 
			
		
		@Test
		public void shouldRetrieveProducts() throws Exception {
			mvc.perform(get("/products")).andExpect(status().isOk());
		}
		
		@Test
		public void shouldIndividualProducts() throws Exception {
			when(productRepo.findOne(42L)).thenReturn(new Product("some product"));
			//had trouble with Jackson converting to Json on product.class used actual object instead
			mvc.perform(get("/products/42")).andExpect(status().isOk());
		}//testing to see if statuses are ok if product exists
 
		@Test
		public void shouldNotFindProductId() throws Exception  {
			mvc.perform(get("/products/42")).andExpect(status().isNotFound());
			//inorder to get test to pass,we need to go to not found excpetion and adjust to throw a 404;
			
			
		}
		
		
}
