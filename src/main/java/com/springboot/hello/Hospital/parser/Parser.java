package com.springboot.hello.Hospital.parser;

public interface Parser <T>{
    T parse(String str);
}
