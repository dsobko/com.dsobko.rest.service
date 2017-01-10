package com.dsobko.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by dsobko on 01/06/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.dsobko.test", plugin = {"pretty", "json:target/cucumber.json"})
public class AllFeatures {
}
