package ro.mta.se.lab.DataModel;

public class CityObject {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;
    public String name;
    public double lat;
    public double longit;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongit() {
        return longit;
    }

    public void setLongit(double longit) {
        this.longit = longit;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String countryCode;

    public CityObject(String id, String cityName, String lat, String longit, String countryCode)
    {
        this.id = id;
        this.name = cityName;
        this.lat = Double.parseDouble(lat);
        this.longit = Double.parseDouble(longit);
        this.countryCode = countryCode;
    }


}
