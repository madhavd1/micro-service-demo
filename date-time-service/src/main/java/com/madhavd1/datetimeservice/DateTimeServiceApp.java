package com.madhavd1.datetimeservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@RestController
@FeignClient("date-time-service")
public class DateTimeServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(DateTimeServiceApp.class, args);
	}

	@Value("${eureka.instance.instance-id}")
	private String portnum;
	
	@GetMapping("/DateTime")
	public String DateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return String.format("The date is %s and the App Instance is %s",dateFormat.format(date),portnum );
	}
	

}
