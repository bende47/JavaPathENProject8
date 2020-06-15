package tripPricer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tripPricer.Provider;
import tripPricer.service.TripPricerService;
import tripPricer.user.User;

@RestController
public class TripPricerController {

	@Autowired
	TripPricerService tripPricerService;

	@GetMapping("/getTripDeals")
	public List<Provider> getTripDeals(@RequestParam String userName) {
		List<Provider> providers = tripPricerService.getTripDeals(getUser(userName));
		return providers;
	}

	private User getUser(String userName) {
		return tripPricerService.getUser(userName);
	}

}