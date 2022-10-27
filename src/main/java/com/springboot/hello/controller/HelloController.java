package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//@RequestMapping("/api/v1/get-api")
public class HelloController {
    
    // 기본적인 메소드 작성법과 다른 메소드 작성법
    //@RequestMapping(value = "/hello", method = RequestMethod.GET) // 고전적인 방법
    @GetMapping("hello") // 다른 메소드 작성법
    public String hello(){
        return "Hello World";
    }

    // 파라미터 없이 GET API 호출하는 경우
    ///api/v1/get-api/name
    @GetMapping(name = "/name")
    public String getName(){
        return "dokim";
    }

    // 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법
    // URL변수명과 파라미터 변수명 일치
//    @GetMapping(name = "/variable1/{variable}") // 밑의 String 변수 이름과 같아야 한다.
//    public String getVariable1(@PathVariable String variable){
//        return variable;
//    }

    // 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법2
    // URL 변수명과 파라미터 변수명을 일치시키지 못할 경우
//    @GetMapping(name = "/variable2/{variable}")
//    public String getVariable2(@PathVariable String variable){
//        return variable;
//    }

    
//    @GetMapping(value = "/request1")
//    public String getReuestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organizaiton) {
//        return name + " " + email + " " + organizaiton;
//    }
//
//    @GetMapping(value = "/request2")
//    public String getReuestParam2(@RequestParam Map<String, String> param) {
//        param.entrySet().forEach((map)->{
//            System.out.printf("key:%s value:%s\n",map.getKey(),map.getValue());
//        });
//        return "request2가 호출 완료 되었습니다";
//    }
//
//    @GetMapping(value = "/request3")
//    public String getReuestParam3(MemberDto memberDto){
//        return memberDto.toString();
//    }
}
