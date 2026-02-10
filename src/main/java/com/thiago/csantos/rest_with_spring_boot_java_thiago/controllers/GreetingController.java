package com.thiago.csantos.rest_with_spring_boot_java_thiago.controllers;

import com.thiago.csantos.rest_with_spring_boot_java_thiago.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "content", defaultValue = "world") String content) {
        return new Greeting(this.counter.incrementAndGet(), String.format(template, content));
    }
}
