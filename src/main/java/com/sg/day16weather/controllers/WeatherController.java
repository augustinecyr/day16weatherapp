package com.sg.day16weather.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sg.day16weather.models.Weather;
import com.sg.day16weather.services.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    // connect the service
    @Autowired
    private WeatherService weatherSvc;

    //step 1
    @GetMapping
    public String getWeather(Model model, @RequestParam String city) {
        weatherSvc.getWeather(city);
        List<Weather> weather = weatherSvc.getWeather(city);
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        return "weather";

    }
    

}
