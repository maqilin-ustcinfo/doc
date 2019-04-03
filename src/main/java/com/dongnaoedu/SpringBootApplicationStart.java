package com.dongnaoedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.dongnaoedu.mapper")
public class SpringBootApplicationStart {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationStart.class, args);
	}
	
}
