package com.wellpoint.microservices.configserver;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConfigServerApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Value("${local.server.port}")
	private int port = 0;

	@Test
	public void configurationAvailableForClaimantService() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + port + "/dev/claimantservice", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	
	@Test
	public void configurationAvailableForHelloWorld() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + port + "/dev/helloworld", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
}