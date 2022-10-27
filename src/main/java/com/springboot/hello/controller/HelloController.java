package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello World";
    }

    @GetMapping(name = "/name")
    public String getName(){
        return "dokim";
    }

    @GetMapping(name = "/variable/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

}
