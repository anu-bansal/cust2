package com.kkd.customerloginservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CustomerLoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerDetailsServiceProxy proxy;
	
	@HystrixCommand(fallbackMethod="fallBackCustomerLogin")
	@PostMapping("/customer/user/{mobileNo}")
	public String postMobileNo(@RequestBody CustomerLoginBean customerLoginBean) {
		logger.info("{}", "Getting entered mobile no. and password during login");
		CustomerLoginBean details=proxy.tarunMethod(customerLoginBean);
		if(customerLoginBean.getPassword().equals(details.getPassword()))
	           return "success";
		else
			return "wrong password";
	     
	   }
	public String fallBackCustomerLogin() {
		return "fallback for mobile no.";
	}

}
