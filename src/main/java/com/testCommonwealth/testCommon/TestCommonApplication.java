package com.testCommonwealth.testCommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class TestCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCommonApplication.class, args);
	}

}
