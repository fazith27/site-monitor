package com.fazith.sitemonitor;

import com.fazith.sitemonitor.repository.LocalStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SiteMonitorApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SiteMonitorApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SiteMonitorApplication.class);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		LocalStore.initializeLocalStore();
	}

}
