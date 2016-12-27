package com.dsobko.test.steps;

import com.dsobko.test.services.MainService;
import com.dsobko.test.utils.CucumberStep;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dsobko on 09/09/2016.
 */
@CucumberStep
public class MainSteps {

    @Autowired
    MainService service;

    @Given("^API is accessible$")
    public void apiIsAccessible() {
        service.init();
        service.sendRequest();
    }
}
