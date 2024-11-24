package com.tutorial.springboot.LearnSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * after running maven install or Gradle bootjar, jar file is ready to execute run the following
 * command the execute the jar file:
 *  	java -jar .\springboot-0.0.1-SNAPSHOT.jar
 * 
 * run on different port number by add --server.port=<port_number>
 * 		java -jar .\springboot-0.0.1-SNAPSHOT.jar --server.port=8081
 */

// Exclude the specific auto-configuration classes that by using the exclude
// attribute to disable them.
// @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
// or use spring.autoconfigure.exclude in property file

// Additional packages can be configured using the @AutoConfigurationPackage annotation.
// @SpringBootApplication annotation which implicitly inlcudes 

// @SpringBootConfiguration - enable registration of extra beans in the context,
// or the import of additional configuration classes. 
// @Import({ SomeConfiguration.class, AnotherConfiguration.class })
// An alternative to Spring’s standard 
// @Configuration that aids configuration detection in your integration tests.

// @EnableAutoConfiguration - enable Spring Boot’s auto-configuration mechanism,

// @ComponentScan - enable @Component scan on the package where the application is located. 
// All of your application components (@Component, @Service, @Repository, @Controller, 
// and others) are automatically registered as Spring Beans.
@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}
