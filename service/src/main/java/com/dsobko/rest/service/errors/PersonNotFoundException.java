package com.dsobko.rest.service.errors;

/**
 * Created by dsobko on 09/23/2016.
 */
public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(String id) {
        super(String.format("No person entry found with id: <%s>", id));
    }
}
