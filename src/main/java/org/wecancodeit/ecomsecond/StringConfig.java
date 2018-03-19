package org.wecancodeit.ecomsecond;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {
	
	@Bean
	public String myOneAndOnlyString() {
		return "shazam"; 
		
	}
	
	@Bean
	public String anotherString() {
		return "another string";
	}
	
	@Bean 
	String beetlebrox() {
		return "Is this the String you are looking for"; 
	}
	
}
