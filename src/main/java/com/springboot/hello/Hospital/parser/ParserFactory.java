package com.springboot.hello.Hospital.parser;

import com.springboot.hello.Hospital.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactory {

    @Bean
    public ReadLineContext2<Hospital> hospitalReadLineContext(){
        return new ReadLineContext2<Hospital>(new HospitalParser());
    }

}
