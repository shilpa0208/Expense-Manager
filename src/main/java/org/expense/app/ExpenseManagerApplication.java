package org.expense.app;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
	}
	
	/**
	 * This is required to enable using h2 db using the web console
	 * 
	 * URL: http://localhost:8080/db
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean h2ServletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		// This allows other computers to connect. Not really required
		// registrationBean.addInitParameter("webAllowOthers", "true");
		registrationBean.addUrlMappings("/db/*");
		return registrationBean;
	}
}
