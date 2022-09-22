package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @RequestMapping("info")
    public String carInfo(@RequestParam String make){
        System.out.println(make);

        return "car/car-info";
    }
}
