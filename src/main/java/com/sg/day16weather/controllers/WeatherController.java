package com.sg.day16weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    //step 1
    @GetMapping
    public String getWeather(Model model, @RequestParam String city) {
        model.addAttribute("city", city);
        return "weather";

    }
}
