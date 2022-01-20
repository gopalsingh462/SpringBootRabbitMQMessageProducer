package com.macy;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MacysOrderMessageProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacysOrderMessageProducerApplication.class, args);
	}
	
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.macy"))
				.paths(PathSelectors.ant("/ordermessageproducer/**"))
//				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Macy's Order Producer Microservice Documentation",
				"REST APIs released by Gopal Singh",
				"1.0",
				"http://zensar.com/termsofservice",
				new Contact("Gopal", "http://nspointers.com","gopalsingh462@gmail.com"),
				"GPL",
				"http://gpl.com",
				new ArrayList<VendorExtension>());
	}

}
