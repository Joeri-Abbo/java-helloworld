package com.joeriabbo.helloworld.Routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {

    @GetMapping("/")
    public String response() {
        return "Hello!";
    }
}
