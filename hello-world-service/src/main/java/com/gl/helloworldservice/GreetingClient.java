package com.gl.helloworldservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service-app")
public interface GreetingClient {
    @GetMapping("/hello")
    String sendGreeting(@RequestParam(value = "name", required = false, defaultValue = "${hello-service-app.usrname}") String name);
}
