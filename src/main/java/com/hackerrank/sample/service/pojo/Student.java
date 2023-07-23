package com.hackerrank.sample.service.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Student.Builder.class)
public class Student {
    private String name;
    private String surname;
    private int age;
    private int number;
    public Student(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.number = builder.number;
    }
    public String getName() {
        return name;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSurname() {
        return surname;
    }
    @JsonIgnore
    public int getAge() {
        return age;
    }
    public int getNumber() {
        return number;
    }
    @JsonPOJOBuilder(buildMethodName = "buildStudent", withPrefix = "set")
    public static class Builder {
        String name;
        String surname;
        private int age;
        private int number;
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        @JsonIgnore
        public Builder setNumber(int number) {
            this.number = number;
            return this;
        }
        public Student buildStudent() {
            return new Student(this);
        }
    }
}
