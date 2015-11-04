package car;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hadoop on 04/11/15.
 */
@XmlRootElement
public class LastStatistics {
    private double latitude;
    private double longitude;
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
