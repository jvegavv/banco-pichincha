package com.banco.pichincha;

import com.banco.pichincha.controller.InitController;
import com.banco.pichincha.dto.Request;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(InitController.class)
public class BancoPichinchaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void errorRequestNull() throws Exception {

		this.mockMvc.perform(post("/DevOps"))
				.andExpect(status().isUnsupportedMediaType());

	}

	@Test
	public void RequestOK() throws Exception {

		Request request = new Request();
		request.setTo("Jorge");

		String json = mapper.writeValueAsString(request);
		
		this.mockMvc.perform(post("/DevOps").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.message").value("Hello Jorge your message will be send"));

	}

}
