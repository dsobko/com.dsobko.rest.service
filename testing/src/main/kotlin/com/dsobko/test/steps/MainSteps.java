package com.dsobko.test.steps;

import com.dsobko.test.services.MainService;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dsobko on 09/09/2016.
 */
public class MainSteps extends AbstractSteps {

    @Autowired
    MainService service;

    @Given("^API is accessible$")
    public void apiIsAccessible() {
        service.verifyApiIsAccessible();
    }
}
