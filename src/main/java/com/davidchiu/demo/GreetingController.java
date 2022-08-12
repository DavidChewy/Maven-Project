package com.davidchiu.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController // this means we are not building the webservice with HTML pages, we want it to return a JSON payload.
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/greeting")
    Greeting greeting(@RequestParam(defaultValue = "David") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
