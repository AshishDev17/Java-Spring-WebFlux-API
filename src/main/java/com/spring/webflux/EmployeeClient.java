package com.spring.webflux;

import org.springframework.web.reactive.function.client.WebClient;

public class EmployeeClient {
    WebClient client = WebClient.create("http://localhost:8080");
}
