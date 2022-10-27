package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

    // 기본적인 메소드 작성법과 다른 메소드 작성법
    //@RequestMapping(value = "/hello", method = RequestMethod.GET) // 고전적인 방법
    @GetMapping("/hello") // 다른 메소드 작성법
    public String hello() {
        return "Hello World";
    }


    //http://localhost:8080/api/v1/get-api/name
    // 파라미터 없이 GET API 호출하는 경우
    // /api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "dokim";
    }


    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    //http://localhost:8080/api/v1/get-api/variable1/Iamhungrycoder
    // 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법
    // URL변수명과 파라미터 변수명 일치
    @GetMapping(value = "/variable1/{variable}") // 밑의 String 변수 이름과 같아야 한다.
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }


    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    //http://localhost:8080/api/v1/get-api/variable2/Iamhungrycoder
    // 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법2
    // URL 변수명과 파라미터 변수명을 일치시키지 못할 경우 => 변수 관리 용이
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable String variable) {
        return variable;
    }


    //http://localhost:8080/api/v1/get-api/request1?name=dokim&email=dokim@mail.com&organization=DDDOOOKKKIIIMMM
    // GET 형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
    // '?'를 기준으로 우측에 {키}={값} 형태로 전달되며, 복수형태로 전달할 경우 &를 사용
    @GetMapping(value = "/request1")
    public String getReuestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }


    //http://localhost:8080/api/v1/get-api/request2?key1=dokim&key2=mkiod
    // GET 형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
    // 어떤 요청값이 들어올지 모를 경우 사용하는 방식, Map 을 사용
    @GetMapping(value = "/request2")
    public String getReuestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach((map) -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }


    //http://localhost:8080/api/v1/get-api/request3?name=dokim&email=dokim@mail.com&organization=DDDOOOKKKIIIMMM
    // DTO사용
    // GET 형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
    // key와 value가 정해져있지만, 받아야할 파라미터가 많을 경우 DTO 객체를 사용한 방식
    @GetMapping(value = "/request3")
    public String getReuestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
