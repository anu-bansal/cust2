package com.kkd.customerloginservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Customer-details-service")
@RibbonClient(name="Customer-details-service")
public interface CustomerDetailsServiceProxy {
	
	@GetMapping("/customer/user/{mobileNo}")
	public CustomerLoginBean tarunMethod(CustomerLoginBean customerLoginBean);
	
}