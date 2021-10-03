package example.spring.r2dbc;

import org.reactive.r2dbc.iclient.annotation.R2dbcMapperScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "example.spring.r2dbc" })
@R2dbcMapperScanner("example.spring.r2dbc.repository")
public class SpringR2dbcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringR2dbcExampleApplication.class, args);
	}

}
