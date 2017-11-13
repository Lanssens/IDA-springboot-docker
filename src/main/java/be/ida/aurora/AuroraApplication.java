package be.ida.aurora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://stackoverflow.com/questions/24074749/spring-boot-cannot-determine-embedded-database-driver-class-for-database-type
@SpringBootApplication
public class AuroraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuroraApplication.class, args);
	}
}
