package com.oscar.txt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:values.properties", encoding = "UTF-8")
public class ArchivotxtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchivotxtApplication.class, args);
	}

}
