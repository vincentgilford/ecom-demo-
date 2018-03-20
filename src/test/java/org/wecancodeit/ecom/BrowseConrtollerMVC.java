package org.wecancodeit.ecom;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@RunWith(SpringRunner.class)
public class BrowseConrtollerMVC {

		@Resource
		private MockMvc mvc; 
		
		@Test
		public void shouldRetrieveProducts() throws Exception {
			mvc.perform(get("/products")).andExpect(status().isOk());

		}
}
