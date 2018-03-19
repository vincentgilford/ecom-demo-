package org.wecancodeit.ecomsecond;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Foo {
	
	@Override
	public String toString() {
		return "Foo [beetlebrox=" + beetlebrox + "]";
	}

	@Resource
	private String beetlebrox; 
	
	
}
