package com.dsobko.test.services

import io.restassured.RestAssured
import io.restassured.RestAssured.requestSpecification
import io.restassured.RestAssured.reset
import io.restassured.builder.RequestSpecBuilder
import io.restassured.response.ValidatableResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Created by dsobko on 09/09/2016.
 */
@Component
open class MainService {

    private val LOGGER = LoggerFactory.getLogger(MainService::class.java)

    fun init() {
        reset()
        requestSpecification = RequestSpecBuilder().setBaseUri("http://localhost").setPort(8080).build()
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