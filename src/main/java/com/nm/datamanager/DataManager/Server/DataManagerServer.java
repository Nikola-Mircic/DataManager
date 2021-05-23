package com.nm.datamanager.DataManager.Server;


import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@SpringBootConfiguration
@RestController
@RequestMapping("/**")
public class DataManagerServer {
	private final String[] args;
	
	public DataManagerServer(String[] args) {
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
