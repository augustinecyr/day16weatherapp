package com.sg.day16weather.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private static final String URL = "https://api.openweathermap.org/data/2.5/weather";

    @Value("${API_KEY}") // export key on cli
    private String key;

    public void getWeather(String city) {
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
            return;
        }
        
        String payload = resp.getBody();
        System.out.println("payload: " + payload);
    }
}
