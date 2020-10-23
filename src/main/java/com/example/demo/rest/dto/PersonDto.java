package com.example.demo.rest.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PersonDto {

    String name;
    int age;
}
