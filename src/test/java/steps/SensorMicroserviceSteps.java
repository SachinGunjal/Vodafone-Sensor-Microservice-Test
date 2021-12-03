package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Sensor;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SensorMicroserviceSteps {

    Response response;
    private final String BASE_URL = "/v2";

    @Given("^User makes POST request to (.*) endpoint with below sensor details$")
    public void addSensor(String endpoint, DataTable datatable) throws JsonProcessingException {
        List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
        Sensor sensor = new Sensor();
        sensor.setId(Integer.valueOf(data.get(0).get("id")));
        sensor.setDob(data.get(0).get("dateOfBirth"));
        sensor.setName(data.get(0).get("name"));
        sensor.setOwnerID(Integer.valueOf(data.get(0).get("ownerID")));
        sensor.setPhotoUrls(Collections.singletonList(data.get(0).get("photoUrls")));

        ObjectMapper objectMapper = new ObjectMapper();
        String sensorRequestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sensor);

        response = given().log().all().header("Content-type", "application/json")
                .and()
                .body(sensorRequestBody)
                .when()
                .post(BASE_URL + endpoint)
                .then().log().all().and().extract().response();

    }

    @Then("User will get a {int} response")
    public void userWillGetAResponse(int statusCode) {
        this.response.then().log().body().statusCode(statusCode);
    }

    @And("^The response contains valid sensor details with (.*)$")
    public void theResponseContainsValidSensorDetails(String sensorId) {
        Sensor sensor = this.response.jsonPath().getObject("$", Sensor.class);
        Assert.assertEquals("Sensor ID does not match", sensor.getId(), Integer.valueOf(sensorId));
    }

    @And("Valid sensor has been added to the database")
    public void validSensorHasBeenAddedToTheDatabase() {
        //Mongodb connection url
        //Get document and validate the details
    }

    @Given("^User makes GET request to (.*) endpoint$")
    public void getSensorDetailsByID(String endpoint) {
        response = given().log().all().request("GET", BASE_URL + endpoint).then().log().all().and().extract().response();
    }

}
