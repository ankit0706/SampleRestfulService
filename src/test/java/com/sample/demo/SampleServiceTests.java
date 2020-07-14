package com.sample.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class SampleServiceTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGermanService() throws Exception {
		System.out.println("mvc = " + mvc);
		ResultActions result = mvc.perform(get("/german").param("name", "Ankit"));
		MvcResult mvcResult = result.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		String content = response.getContentAsString();
		System.out.println("status = " + status + " content = " + content);
	}

}
