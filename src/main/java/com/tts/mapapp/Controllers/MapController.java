package com.tts.mapapp.Controllers;

import com.tts.mapapp.Models.Location;
import com.tts.mapapp.Services.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {
    
    @Autowired
    MapService mapService;

    @GetMapping("/home")
    public String getDefaultMap(Model model) {
        model.addAttribute(new Location());
        
        // Location location = new Location();
        
        // location.setCity("New Orleans");
        // location.setState("Louisiana");

        // mapService.addCoordinates(location);
        // System.out.println(location);

        return "index.html";
    }

    @PostMapping("/home")
    public String getMapForLocation(Location location, Model model) {
        
        mapService.addCoordinates(location);
        model.addAttribute(location);

        return "index";
    }

    @PostMapping("/random")
    public String getRandomLocation(Model model){

        Location city = mapService.randomCity();

        model.addAttribute(city);

        return "index";
    }

}