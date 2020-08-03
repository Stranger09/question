package com.example.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {
    //MainPage
    @GetMapping("/")
    public String mainPage() {
       return "/main";
    }

    //@GetMapping("/authorized")
    //public String login() {
    //    return "/authorized";
    //}



}
