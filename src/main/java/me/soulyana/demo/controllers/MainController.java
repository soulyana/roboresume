package me.soulyana.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index()
    {
        return "Welcome to your Robo Resume!";
    }
}
