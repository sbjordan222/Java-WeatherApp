package com.tts.WeatherApp.Services;

import com.tts.WeatherApp.Repositories.ZipCodeRepository;
import com.tts.WeatherApp.Models.Response;
import com.tts.WeatherApp.Models.ZipCodes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	@Value("${api_key}")
	private String apiKey;
	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	//MAKE A CALL TO OPENWEATHER API, WITH DYNAMIC ZIPCODE AND APIKEY
	public Response getForecast(String zipCode){
		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid=" + apiKey;
		//zipCodeRepository.save(zipCode);
		RestTemplate restTemplate = new RestTemplate();
		
		//MAKE A CALL TO "URL"
		//SHOVE THE RESPONSE IN A RESPONSE "OBJECT"
		try{
			return restTemplate.getForObject(url, Response.class);
		}catch(HttpClientErrorException exception){
			Response response = new Response();
			response.setName("ERROR");
			return response;
		}
	}
	
//	public ZipCodes save(ZipCodes zipcodes) {
//		return zipCodeRepository.save(zipcodes);
//	}
	
//	public List<ZipCodes> getAllZipCodes() {
//		List<ZipCodes> zipcodes = new ArrayList<>();
//		zipCodeRepository.findAll()
//		.forEach(zipcodes::add);
//		return zipcodes;
//	}
	
	public ZipCodes findByZipCode(String zip) {
		return zipCodeRepository.findByZipCode(zip);
	}
	
	public List<String> findMostRecent() {
		return zipCodeRepository.findMostRecent();
	}
	
	public void createZip(String zip) {
		ZipCodes zipCode = new ZipCodes();
		zipCode.setZipCode(zip);
		
		zipCodeRepository.save(zipCode);
	}
}