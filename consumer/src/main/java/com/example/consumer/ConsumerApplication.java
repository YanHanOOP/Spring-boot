package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
/*
	public static void main(String[] args) {
		// SpringApplication.run(ConsumerApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(ConsumerApplication.class, args);

		RestTemplate restTemp = ctx.getBean(RestTemplate.class);

		String val = restTemp.getForEntity("http://Say-Hi/hi", String.class).getBody();

		System.out.println("getVal=" + val);
	}
	*/
}
