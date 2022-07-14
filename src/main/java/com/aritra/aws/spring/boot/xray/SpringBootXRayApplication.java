package com.aritra.aws.spring.boot.xray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableFeignClients(basePackages = {"com.aritra.aws.spring.boot.xray.service.clients"})
public class SpringBootXRayApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootXRayApplication.class, args);
		
	}

}
