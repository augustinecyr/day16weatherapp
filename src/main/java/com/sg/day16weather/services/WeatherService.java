package com.sg.day16weather.services;


import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sg.day16weather.models.Weather;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class WeatherService {

    private static final String URL = "https://api.openweathermap.org/data/2.5/weather";

    @Value("${API_KEY}") // export key on cli
    private String key;

    public List<Weather> getWeather(String city) {
        // create url with query string
        String url = UriComponentsBuilder.fromUriString(URL)
                .queryParam("q", city) // get from POSTMAN
                .queryParam("appid", key) // get from POSTMAN
                .toUriString();
        // GET request
        RequestEntity<Void> req = RequestEntity.get(url).build();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);


        // condition to check if resp is successful

        if (resp.getStatusCodeValue() != 200) {
            System.err.println("Error");
            return Collections.emptyList();
        }
        
        String payload = resp.getBody();
        System.out.println("payload: " + payload);
        
        // convert payload to json
        // convert the string to reader
        Reader strReader = new StringReader(payload);
        // create a json reader from Reader
        JsonReader jsonReader = Json.createReader(strReader);
        // read the payload as json object 
        JsonObject weatherResult = jsonReader.readObject();
        JsonArray cities = weatherResult.getJsonArray("weather");
        List<Weather> list = new LinkedList<>();
        
        for (int i = 0; i < cities.size(); i++)
        {
            // weather[0]
            JsonObject jo = cities.getJsonObject(i);
            list.add(Weather.create(jo));
       
        }
        return list;
        
    }
}
