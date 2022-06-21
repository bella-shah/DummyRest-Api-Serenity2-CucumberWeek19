package com.restapiexample.employeeinfo;


import com.restapiexample.constants.EndPoints;
import com.restapiexample.model.EmployeePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class EmployeeSteps {
    @Step("Creating Employee with status : {0}, record: {1}")
    public ValidatableResponse createUser(String status,
                                          HashMap<String, Object> createRecord) {
        EmployeePojo restAPIPojo = new EmployeePojo();
        restAPIPojo.setStatus(status);
        restAPIPojo.setData(createRecord);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(restAPIPojo)
                .when()
                .post(EndPoints.CREATE_EMPLOYEE)
                .then();
    }

    @Step("Reading an employee ID : 24")
    public ValidatableResponse readingEmployee() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID", 24)
                .when()
                .get(EndPoints.GET_EMPLOYEE_BY_ID)
                .then();
    }
    @Step("Reading an employee ID : 24")
    public ValidatableResponse readingAllEmployee() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_EMPLOYEE)
                .then();
    }

    @Step("Updating an Employee ID 24")
    public ValidatableResponse updatingEmployee(HashMap<String, Object> createRecord) {
        EmployeePojo restAPIPojo = new EmployeePojo();
        restAPIPojo.setData(createRecord);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",24)
                .body(restAPIPojo)
                .when()
                .put(EndPoints.UPDATE_EMPLOYEE_BY_ID)
                .then();
    }

    @Step("Deleting an Employee ID 24")
    public ValidatableResponse deletingEmployee() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("employeeID",24)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE_BY_ID)
                .then();
    }
}