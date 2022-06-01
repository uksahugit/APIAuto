package steps;

import cucumber.api.java.en.Then;
import utils.ScenarioContext;
import utils.Utils;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isOneOf;

public class ReusableSteps extends BaseStepDef {

    public ReusableSteps(ScenarioContext context) {
        super(context);
    }

    @Then("^the operation should be successful$")
    public void the_operation_should_be_successful() {
        context.response.then().statusCode(isOneOf(200, 201));
    }

    @Then("^should include the following values$")
    public void should_include_the_following_values(Map<String, String> responseFields) {
        Utils.assertResponseJsonFields(context.response, responseFields);
    }

    @Then("^the operation should fail$")
    public void the_operation_should_fail() {
        context.response.then().statusCode(isOneOf(400, 500));
    }

    @Then("^the operation should fail because of service unavailable$")
    public void the_operation_should_fail_service_unavaileble() {
        context.response.then().statusCode(isOneOf( 503));
    }

    @Then("^The status should be not found$")
    public void the_status_should_be_not_found() {
        context.response.then().statusCode(is(404));
    }

    @Then("^I store the \"([^\"]*)\" of the response as \"([^\"]*)\"$")
    public void i_store_the_x_of_the_response(String item, String name) {
    //    context.vars.put(name, (Integer)context.response.jsonPath().get(item));

        Integer responseCheck = context.response.jsonPath().get(item);
        context.vars.put(name, responseCheck);
    }

    @Then("^The \"([^\"]*)\" of the response as string should be equal to the stored \"([^\"]*)\"$")
    public void theXOftheResponseasStringShouldBeEqualToTheStoredY(String path, String key) {
        final Integer responseCheck = context.response.jsonPath().get(path);
        final Integer stored = (Integer) context.vars.get(key);
        assertThat(responseCheck, is(stored));
    }

    @Then("^the \"([^\"]*)\" of the response should be \"([^\"]*)\"$")
    public void the_x_of_the_response_should_be_string_y(String path, String check) {
        String responseCheck = context.response.jsonPath().getString(path);
        assertThat(responseCheck, is(check));
    }
}
