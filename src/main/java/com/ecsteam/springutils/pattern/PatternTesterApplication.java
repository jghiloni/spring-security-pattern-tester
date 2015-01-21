package com.ecsteam.springutils.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The main entry point. Added a configure method to disable security, since having spring-boot-starter-security on the
 * classpath enables it by default
 * 
 * @author Josh Ghiloni
 *
 */
@SpringBootApplication
public class PatternTesterApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(PatternTesterApplication.class, args);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().anyRequest();
	}
}
