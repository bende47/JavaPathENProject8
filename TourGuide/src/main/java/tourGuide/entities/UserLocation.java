package tourGuide.entities;

import java.util.UUID;

import gpsUtil.location.Location;

public class UserLocation {
	private UUID userID;
    private Location latLongUser;


    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public Location getLatLongUser() {
        return latLongUser;
    }

    public void setLatLongUser(Location latLongUser) {
        this.latLongUser = latLongUser;
    }
}
