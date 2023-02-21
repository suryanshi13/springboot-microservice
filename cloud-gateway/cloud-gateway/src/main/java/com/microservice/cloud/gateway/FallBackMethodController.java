package com.microservice.cloud.gateway;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/userServiceFallBack")
    @CircuitBreaker(name = "userService", fallbackMethod = "userServiceFallBackMethod")
    public String userServiceFallBackMethod(Exception ex){
        return "User Service is taking longer than Expected." + "Please try again later";
    }
    @GetMapping("/departmentServiceFallBack")
    @CircuitBreaker(name = "departmentService", fallbackMethod = "departmentServiceFallBackMethod")
    public String departmentServiceFallBackMethod(Exception ex){
        return "Department Service is taking longer than Expected." + "Please try again later";
    }
}
