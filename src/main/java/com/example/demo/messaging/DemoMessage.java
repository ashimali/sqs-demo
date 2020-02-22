package com.example.demo.messaging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoMessage {

    private String content;

    @JsonCreator
    public DemoMessage(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
