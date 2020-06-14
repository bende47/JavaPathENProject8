package tourGuide;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TourGuideControllerTest {

	
	@Autowired
	private MockMvc mvc;	
	
	@Test
	public void indexTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(content().string("Greetings from TourGuide!"));
	}
	
	@Test
	public void getLocationTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/getLocation").param("userName", "internalUser38"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getNearbyAttractionsTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/getNearbyAttractions").param("userName", "internalUser38"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void getRewardsTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/getRewards").param("userName", "internalUser38"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void getAllCurrentLocationsTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/getAllCurrentLocations"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}
	
		
	@Test
	public void addUserPreferencesTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/addUserPreferences")
				.param("userName", "internalUser38")
				.param("numberOfAdults", "2")
				.param("numberOfChildren", "1")
				.param("tripDuration", "2")
				.param("highPricePoint", "256")
				.param("lowerPricePoint", "100"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}
	
}
