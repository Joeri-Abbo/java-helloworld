package com.joeriabbo.helloworld.Routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

    @GetMapping("/ping")
    public String response() {
        return "Pong";
    }
}
