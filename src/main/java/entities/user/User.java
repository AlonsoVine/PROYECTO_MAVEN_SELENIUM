package entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("user")
public class User {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("website")
    private String website;
    @JsonProperty("company")
    private Company company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }

    public String getUsername() {
        return username;
    }
}
