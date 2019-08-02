package com.example.weatherforecast.service;

import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weatherforecast.model.ForecastModel;

@Service
public class ForecastService {
  public double forecastWeather(String weatherCity){
	  
	  boolean isMetric = true;
	    String APIKey = "24a021bf52bf3307564fde184620b138"; /* YOUR OWM API KEY HERE */
        // creating the URL
        String url = "http://api.openweathermap.org/data/2.5/forecast/?q=" + weatherCity + "&APPID=" + APIKey;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        RestTemplate temp = new RestTemplate();
        ForecastModel resp = temp.exchange(url, HttpMethod.GET ,entity , ForecastModel.class).getBody();
        return resp.getEntries().get(0).getTemperature();
        
  }
}
