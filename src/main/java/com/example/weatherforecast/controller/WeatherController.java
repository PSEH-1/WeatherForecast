package com.example.weatherforecast.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherforecast.service.ForecastService;

@RestController
public class WeatherController {
	@RequestMapping("/forecast/{city}")
	public String forecastWeather(@PathVariable("city") String city){
		String[] cityValue = city.split("=");
		ForecastService svc = new ForecastService();
		double temprature = svc.forecastWeather(cityValue[1] );
		String message;
		if(((temprature-32)*5)/9 >40){
			message = "Sunscreen";
		}
		else{
			message = "Umbrella";
		}
		return message;
	}

}
