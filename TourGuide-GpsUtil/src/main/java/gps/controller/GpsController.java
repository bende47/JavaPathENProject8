package gps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;

import gps.service.GpsService;
import gps.service.User;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@RestController
public class GpsController {

	@Autowired
	GpsService gpsService;
	
	@GetMapping(value="/getLocation")
    public String getLocation(@RequestParam String userName) {
        VisitedLocation visitedLocation = gpsService.getUserLocation(getUser(userName));
        return JsonStream.serialize(visitedLocation.location);
    }
 
	@GetMapping(value="/getAllAttractions")
	public List<Attraction> getAttractions() {
		return gpsService.getAttractions();
	}
    
    private User getUser(String userName) {
    	return gpsService.getUser(userName);
    }
   

}