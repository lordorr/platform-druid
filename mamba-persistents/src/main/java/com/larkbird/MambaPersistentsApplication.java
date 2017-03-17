package com.larkbird;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MambaPersistentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MambaPersistentsApplication.class, args);
	}
}
