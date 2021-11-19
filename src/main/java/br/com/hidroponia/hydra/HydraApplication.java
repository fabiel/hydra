package br.com.hidroponia.hydra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("br.com.hidroponia")
@ComponentScan(basePackages = "br.com.hidroponia")
@SpringBootApplication
public class HydraApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydraApplication.class, args);
	}

}
