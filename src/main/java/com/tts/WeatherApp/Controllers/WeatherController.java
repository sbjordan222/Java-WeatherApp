package com.tts.WeatherApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherApp.Models.Request;
import com.tts.WeatherApp.Models.Response;
import com.tts.WeatherApp.Models.ZipCodes;
import com.tts.WeatherApp.Repositories.ZipCodeRepository;
import com.tts.WeatherApp.Services.WeatherService;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    
    @Autowired
    private ZipCodeRepository searchRepository;
    
    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("request", new Request());
        List<String> recentZips = weatherService.findMostRecent();
        model.addAttribute("recentzips", recentZips);
        return "index";
    }
    
    @PostMapping("/")
    public String zipCodeSearch(Request zip, Model model) {
    	Response data = weatherService.getForecast(zip.getZipCode());
        List<String> recentZips = weatherService.findMostRecent();
        model.addAttribute("data", data);
        model.addAttribute("recentzips", recentZips);
        return "index";
    }
}