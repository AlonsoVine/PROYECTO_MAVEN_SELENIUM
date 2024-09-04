package entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("address")
public class Address {
    @JsonProperty("street")
    private String street;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("geo")
    private Geo geo;

    public Geo getGeo() {
        return geo;
    }
}
