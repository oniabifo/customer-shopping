package com.packt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;



@SpringBootApplication(scanBasePackages={"com.packt", "com.packt.controller", "com.packt.dao", "com.packt.model"})
//(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class CustomerShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerShoppingApplication.class, args);
	}
}
