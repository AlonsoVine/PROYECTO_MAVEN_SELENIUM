package entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("company")
public class Company {
    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
