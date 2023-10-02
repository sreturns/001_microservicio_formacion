package com.sinensia.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Nuestra clase de configuracion
 * 
 * @see com.sinensia.controller.FormacionController
 */
@SpringBootApplication(scanBasePackages = { "com.sinensia.service", "com.sinensia.controller" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Creamos el @Bean para nuestro template que inyectaremos en nuestro servicio
	 * 
	 * @return template
	 */
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
