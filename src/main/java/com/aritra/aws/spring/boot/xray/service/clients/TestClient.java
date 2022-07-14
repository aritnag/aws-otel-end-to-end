package com.aritra.aws.spring.boot.xray.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="example", url="https://nordcloud.com")
public interface TestClient {

	@GetMapping("/")
	String getNordcloud();
	
}
