package contacts;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.SpringApplication;

@ComponentScan
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}










