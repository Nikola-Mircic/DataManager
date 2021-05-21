package com.nm.datamanger.DataManager;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/**")
public class DataManagerApplication {
	private final String[] args;
	
	public DataManagerApplication(String[] args) {
		this.args = args;
	}

	private ApplicationContext context;
	
	public void start() {
		this.context = SpringApplication.run(getClass(), this.args);
	}
	
	public void stop() {
		SpringApplication.exit(this.context, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				return 0;
			}
		});
	}
	
	@GetMapping("/**")
	public String get() {
		return "<h1 style='color:blue'>Welcome!</h1>";
	}

}
