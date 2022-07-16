package com.joeriabbo.helloworld.Routes;

import org.springframework.web.bind.annotation.RequestParam;

public class Root {
    public String response() {
        return "Hello!";
    }
}
