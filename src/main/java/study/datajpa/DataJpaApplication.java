package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// data jpa 설정, Spring boot 에서 생략 가능
//@EnableJpaRepositories(basePackageClasses = "study.datajpa.repository")
@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

}
