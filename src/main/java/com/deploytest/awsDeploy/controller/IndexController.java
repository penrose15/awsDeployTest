package com.deploytest.awsDeploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/index")
public class IndexController {

    @GetMapping
    public String index() {
        return "gitAction autoDeploy Success!";
    }
}
