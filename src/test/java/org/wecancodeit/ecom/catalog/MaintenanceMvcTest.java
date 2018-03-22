package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(MaintenanceController.class)
public class MaintenanceMvcTest {

	// attempted test is to generate Ids without using the annotations

	@Resource
	private MockMvc mvc; // mocks return nulls for values so we need to tell mvc directly to create a
							// value

	@Resource
	private ObjectMapper jsonMapper;

	@MockBean
	private CrudRepository<Product, Long> productRepo;
	//needed for mvc to inject respository
	//fake repo used to have something to hit then we call a when to make sure that 
 
	
	
	@Test
	public void shouldCreateProduct() throws Exception {
		Product product = new Product("test product");
		String productJson = jsonMapper.writeValueAsString(product); // converting object to json read java doc on
																		// objectmapper
		mvc.perform(post("/products").content(productJson)).andExpect(status().isOk());

	}

	@Test
	public void shouldreturnExpectedProduct() throws Exception {
		when(productRepo.save(any(Product.class))).thenReturn(new Product("response product name"));
		Product product = new Product("test product");
		String productJson = jsonMapper.writeValueAsString(product);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products").content(productJson);
		//post in mock request sets up the requiremetn for post in our controller
		mvc.perform(request.content(productJson)).andExpect(jsonPath("@.name", is("response product name")));
	
		//extract local variables later
		//testing to see if we can post and get back a product
		//testing will have to go higher level test because we do not have a generated Id, our containerRest test will help
	}
}
