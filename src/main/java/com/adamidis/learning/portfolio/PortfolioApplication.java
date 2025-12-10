package com.adamidis.learning.portfolio;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

    static {
        // Loads the .env file and adds the variables to System.getenv
        Dotenv dotenv = Dotenv.configure()
                              .ignoreIfMissing()
                              .load();
        dotenv.entries().forEach(entry ->
            // Set each environment variable if not already set
            System.setProperty(entry.getKey(), entry.getValue()));
    }

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
