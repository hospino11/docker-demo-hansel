package com.example.demo.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Builder
@Value
@ToString
public class Person {
    String id;
    String name;
    int age;
}

