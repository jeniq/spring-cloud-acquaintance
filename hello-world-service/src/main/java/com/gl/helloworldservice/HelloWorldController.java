package com.gl.helloworldservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GreetingClient greetingClient;

    @GetMapping("/hello-world")
    public String greetingTheWorld() {
        //return restTemplate.getForObject("http://HELLO-SERVICE-APP/hello?name=world!", String.class);
        return greetingClient.sendGreeting("world!");
    }

}
