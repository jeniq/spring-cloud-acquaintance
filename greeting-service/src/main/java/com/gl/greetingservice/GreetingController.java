package com.gl.greetingservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

    @HystrixCommand(fallbackMethod = "errorMethod")
    @GetMapping("/hello")
    public String sendGreeting(@RequestParam(value = "name", required = false, defaultValue = "${hello-service-app.usrname}") String name) {
       // throw new RuntimeException();
        return "Hello, " + name;
    }

    public String errorMethod(@RequestParam(value = "name", required = false, defaultValue = "${hello-service-app.usrname}") String name) {
        return "Request is unreachable, please, try again later";
    }

}
