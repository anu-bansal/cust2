package com.kkd.customerloginservice;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.kkd.customerloginservice.CustomerLoginBean;

@RunWith(SpringRunner.class)
@WebMvcTest(value =CustomerLoginController.class, secure = false)
public class CustomerLoginControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
//	private CustomerLoginService customerLoginService;

	CustomerLoginBean mockDetails = new CustomerLoginBean("9872", "anu");

	String exampleDetailsJson = "{\"phone_no\":\"9872\",\"description\":\"anu\"}";

	@Test
	public void retrieveDetailsForCustomer() throws Exception {

//		Mockito.when(
//				customerLoginService.retrieveDetails(Mockito.anyString(),
//						Mockito.anyString())).thenReturn(mockDetails);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/customer/user/{phone_no}").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//System.out.println(result.getResponse());
		String expected = "{phone_no:9872,password:anu}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}


}
