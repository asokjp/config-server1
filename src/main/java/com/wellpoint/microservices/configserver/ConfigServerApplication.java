package com.wellpoint.microservices.configserver;

import io.undertow.UndertowOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
	 public static void main(String[] args) {
	        SpringApplication application = new SpringApplication(ConfigServerApplication.class);
	        application.addListeners(new ApplicationPidFileWriter());
	        application.setWebEnvironment(true);
	        application.run(args);
	    }
	   
		@Bean
		UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
			UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
			factory.addBuilderCustomizers(
					builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
			return factory;
		}
}
