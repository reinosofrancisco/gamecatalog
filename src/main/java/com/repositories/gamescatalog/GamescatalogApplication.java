package com.repositories.gamescatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
public class GamescatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamescatalogApplication.class, args);
	}

}
