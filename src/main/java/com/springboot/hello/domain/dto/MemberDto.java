package com.springboot.hello.domain.dto;

public class MemberDto {
    private String name;
    private String email;
    private String organizaion;

    public MemberDto(String name, String email, String organizaion) {
        this.name = name;
        this.email = email;
        this.organizaion = organizaion;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganizaion() {
        return organizaion;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s", this.name, this.email, this.organizaion);
    }
}
