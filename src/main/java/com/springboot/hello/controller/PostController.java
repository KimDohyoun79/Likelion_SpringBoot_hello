package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/vi/post-api")
public class PostController {

    //http://localhost:8080/api/v1/post-api/default
    @PostMapping(value = "/default")
    public String postMethod(){
        return "Hello post";
    }

    //http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMethod(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue()+ "\n");
        });
        return sb.toString();
    }


    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMethodDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
}
