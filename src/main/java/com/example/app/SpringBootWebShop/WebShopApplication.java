package com.example.app.SpringBootWebShop;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.logging.Logger;

// Вхідна точка в програму.
// @SpringBootApplication позначає головний клас програми.
// @SpringBootApplication інкапсулює анотації @Configuration,
// @EnableAutoConfiguration, @ComponentScan з їхніми атрибутами
// за замовчуванням.
// https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html
@SpringBootApplication
public class WebShopApplication {

	private static final Logger LOGGER =
			Logger.getLogger(WebShopApplication.class.getName());

	public static void main(String[] args) {

		// Можемо прибрати це
//		SpringApplication.run(WebShopApplication.class, args);

		// Формуємо такий код з можливістю
		// уникнення показу банера Spring Boot
		new SpringApplicationBuilder(WebShopApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

		LOGGER.info("APP is running...");
	}
}
