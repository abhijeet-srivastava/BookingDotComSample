package com.hackerrank.sample.service.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = EchoMessage.Builder.class)
public class EchoMessage {
    @JsonProperty("echo")
    private String message;
    public EchoMessage(Builder builder) {
        this.message = builder.message;
    }
    @JsonPOJOBuilder(buildMethodName = "buildMessage", withPrefix = "set")
    public static class Builder {
        String message;
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }
        public EchoMessage buildMessage() {
            return new EchoMessage(this);
        }
    }
}
