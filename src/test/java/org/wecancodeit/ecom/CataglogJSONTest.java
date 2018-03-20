package org.wecancodeit.ecom;

import java.io.IOException;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.ecom.catalog.Product;

@RunWith(SpringRunner.class)
@JsonTest//will apply on things relevant to JSON, ie to see what can be serialized and deserialized,
		//allow for jackson testing fields with objects being tested
public class CataglogJSONTest {
	//testing for Serialization
	
	@Resource
	private JacksonTester<Product> productJson; 
	
	@Test
	public void shouldSerialize() throws IOException {
		Product product = new Product("product name"); 
		JsonContent<Product> content = productJson.write(product); 
		
		Assertions.assertThat(content).extractingJsonPathValue("@.name").isEqualTo("product name"); 
		//jackson is looking for the getters only will pass when proper
		//attributes have their associated getters
	}
	
	public void shouldDeserialize() throws IOException {
		String jsonContent= "{\"name\": \"product anme\"}";
		//must make sure that we turn our string into Json as well, and then in to Json object to ensure for spac
		// make sure parsed content are actual attributes of your tested object
		Product parsed = productJson.parseObject(jsonContent);
		
		Assertions.assertThat(parsed.getName()).isEqualTo("product name"); 
		
		
	}
	
	
	
	
}
