package com.sample.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static Logger LOGGER = Logger.getLogger("GreetingController");
	private static final String template = "Hello, %s!";
	private static final String templateAge = "You are %s years old.";
	private static final String templateG = "Gutten Tag, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	@RequestMapping("/greeting")
	public Greeting getGreeting(@RequestParam(value = "firstName", defaultValue="John Doe") String name, 
			@RequestParam(value="age", defaultValue="0") int ageParam) {
		LOGGER.info("INSIDE getGreeting");
		LOGGER.debug(name);
		return new Greeting(counter.incrementAndGet(), String.format(template, name)
				+ " " + String.format(templateAge, ageParam), simpleDateFormat.format(new Date()));
	}
	
	@GetMapping("/german")
	public Greeting getGreeting2(@RequestParam(value = "name") String name) {
		LOGGER.error("some message");
		LOGGER.warn("INSIDE getGreeting2");
		LOGGER.debug(name);
		LOGGER.info("some info");
		return new Greeting(counter.incrementAndGet(), String.format(templateG, name), simpleDateFormat.format(new Date()));
	}
	
}
