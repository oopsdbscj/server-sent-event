package com.gouermazi.sse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by tab chan on 2018/04/22
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "stock";
    }
}
