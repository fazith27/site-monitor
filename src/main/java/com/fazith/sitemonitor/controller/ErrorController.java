package com.fazith.sitemonitor.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }
}
