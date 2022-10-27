package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping(name = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    @GetMapping(name = "/variable2/{variable}")
    public String getVariable2(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getReuestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organizaiton) {
        return name + " " + email + " " + organizaiton;
    }

    @GetMapping(value = "/request2")
    public String getReuestParam2(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map)->{
            System.out.printf("key:%s value:%s\n",map.getKey(),map.getValue());
        });
        return "request2가 호출 완료 되었습니다";
    }

    @GetMapping(value = "/request3")
    public String getReuestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
