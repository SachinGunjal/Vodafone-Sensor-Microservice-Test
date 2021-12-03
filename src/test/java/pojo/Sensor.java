package pojo;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "dateOfBirth",
        "name",
        "ownerID",
        "photoUrls"
})
@Generated("jsonschema2pojo")
public class Sensor {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("dateOfBirth")
    private String dob;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ownerID")
    private Integer ownerID;
    @JsonProperty("photoUrls")
    private List<String> photoUrls = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("dateOfBirth")
    public String getDob() {
        return dob;
    }

    @JsonProperty("dateOfBirth")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("photoUrls")
    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    @JsonProperty("photoUrls")
    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    @JsonProperty("ownerID")
    public Integer getOwnerID() {
        return ownerID;
    }

    @JsonProperty("ownerID")
    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}