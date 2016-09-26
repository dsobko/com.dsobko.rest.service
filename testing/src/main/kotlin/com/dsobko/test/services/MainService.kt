package com.dsobko.test.services

import com.jayway.restassured.RestAssured
import com.jayway.restassured.builder.RequestSpecBuilder
import com.jayway.restassured.response.ValidatableResponse
import org.slf4j.LoggerFactory

/**
 * Created by dsobko on 09/09/2016.
 */
open class MainService {

    private val LOGGER = LoggerFactory.getLogger(MainService::class.java)

    fun initiate() {
        RestAssured.reset()
        val spec = RequestSpecBuilder().setBaseUri("http://localhost:8080").build()
        RestAssured.requestSpecification = spec
        }

    open fun sendRequest(): ValidatableResponse? {
        LOGGER.info("Sending request")
        return RestAssured.given()
                .get("/api/person/")
                .then()
                .log()
                .ifError()
    }
}