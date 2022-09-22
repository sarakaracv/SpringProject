package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(){
        return "home.html";
    }

    @RequestMapping("/ozzy")
    public String getHomePage2(){
        return "home.html";
    }

    @RequestMapping // nothing and /
    public String getHomePage3(){
        return "home.html";
    }

    @RequestMapping ({"/apple","/orange"})
    public String getHomePage4(){
        return "home.html";
    }


}
