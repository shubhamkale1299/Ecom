package org.zeroclub.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(EcomApplication.class, args);
//	}


public static void main(String[] args) {
	System.out.println("Java TimeZone: " + java.util.TimeZone.getDefault());
	SpringApplication.run(EcomApplication.class, args);
}
}