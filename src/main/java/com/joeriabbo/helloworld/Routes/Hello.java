package com.joeriabbo.helloworld.Routes;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Hello {
    public String response(String name) {
        return String.format("Hello %s!", name);
    }
}
