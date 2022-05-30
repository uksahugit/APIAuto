package steps;

import cucumber.api.java.en.When;
import utils.ScenarioContext;
import steps.BaseStepDef;

import static endpoints.UserManipulationEndpoints.*;

public class UserManipulationStepDefs extends BaseStepDef {
    public UserManipulationStepDefs(ScenarioContext context) {
        super(context);
    }

    @When("^I try to find the list of users in page (\\d+)$")
    public void i_try_to_find_the_number_of_users(int page) {
        context.response = listUsers(page);
        context.response.jsonPath().prettyPrint();
    }

    @When("^I try to find a single user with id (\\d+)$")
    public void i_try_to_find_a_single_user(int id) {
        context.response = singleUser(id);
        context.response.jsonPath().prettyPrint();
    }

    @When("^I try to find a single user with stored id \"([^\"]*)\"$")
    public void i_try_to_find_a_single_user_using_stored_id(String key) {
        Integer stored = (Integer) context.vars.get(key);
        Integer id = Integer.valueOf(stored);
        context.response = singleUserGoRest(id);
        context.response.jsonPath().prettyPrint();
    }

    @When("^I try to create a user with the following data$")
    public void i_try_to_create_a_user(String json) {
        context.response = createUser(json);
        context.response.jsonPath().prettyPrint();
    }

    @When("^I try to get the data$")
    public void iTryToGetTheData() {
        context.response = getData();
    }
}
