package org.trainings.charan.springjdbch2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.trainings.charan.springjdbch2.repository")
public class SpringJdbcH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcH2Application.class, args);
	}

}
