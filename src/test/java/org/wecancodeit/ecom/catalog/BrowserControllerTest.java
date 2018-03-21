package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;

public class BrowserControllerTest {

	@InjectMocks
	private BrowseController underTest; // this is what is to be tested and therefore needs the injection
										//the rest are mocks

	@Mock
	private CrudRepository<Product, Long> productRepo;
	// using the most general thing until needed

	@Mock
	private Product product;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void useMocks() {
		Iterable<Product> result = underTest.findProducts();

		when(productRepo.findAll()).thenReturn(Collections.singleton((product)));

		assertThat(result, contains(product));

	}

	@Test
	public void shouldGetProducts() {
		BrowseController underTest = new BrowseController();

		Iterable<Product> result = underTest.findProducts();

		assertThat(result, contains(any(Product.class))); //Iterable does not have a size method
	}

	@Test
	public void shouldGetProductsFromDb() {
		// if we want to use a mock repository we may run into the issue
		// we want to inject mocks via BrowserController
		//
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));

		Iterable<Product> result = underTest.findProducts();
		
		assertThat(result, contains(product));
		
		
		
	}

	@Test
	public void shouldGetAnIndividualProduct() {
		long id = 42L; 
		
		when(productRepo.findOne(id)).thenReturn(product); 

		 Product result = underTest.findProduct(id);
		 //I am confused by this why are we giving it a long??
		 

		 assertThat(result, is(product));
		 //finding product in controller
		 
	}
	// we want to verify it is talking to our mock repository
	// want to make sure asctula product given is mocked product; 
	
	@Test(expected = ProductNotFoundException.class)
	public void shouldRetunrNotFoundForBadProductID() {
		//we are expecting to throw an exception
		//
		long invalidProductID = 42L;
		underTest.findProduct(invalidProductID); 
		
	}
}