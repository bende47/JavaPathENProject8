package tourGuide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;

import gpsUtil.location.VisitedLocation;
import tourGuide.entities.FiveNearestAttractions;
import tourGuide.entities.UserLocation;
import tourGuide.service.TourGuideService;
import tourGuide.user.User;
import tripPricer.Provider;

@RestController
public class TourGuideController {

	@Autowired
	TourGuideService tourGuideService;
	
	@GetMapping("/")
    public String index() {
        return "Greetings from TourGuide!";
    }

    @GetMapping(value="/getLocation")
    public String getLocation(@RequestParam String userName) {
        VisitedLocation visitedLocation = tourGuideService.getUserLocation(getUser(userName));
        return JsonStream.serialize(visitedLocation.location);
    }
   
    @GetMapping(value="/getNearbyAttractions")
    public FiveNearestAttractions getNearbyAttractions(@RequestParam String userName) {
        VisitedLocation visitedLocation = tourGuideService.getUserLocation(getUser(userName));
        return tourGuideService.get5NearestAttractions(visitedLocation);
    }
    
    @GetMapping("/getRewards")
    public String getRewards(@RequestParam String userName) {
        return JsonStream.serialize(tourGuideService.getUserRewards(getUser(userName)));
    }
    
    @GetMapping("/getAllCurrentLocations")
    public List<UserLocation> getAllCurrentLocations() {
       return tourGuideService.getLocationOfAllUsers();
    }    

    
    private User getUser(String userName) {
    	return tourGuideService.getUser(userName);
    }
   

}