package com.dsobko.rest.service

import org.springframework.stereotype.Service

/**
 * Created by dsobko on 09/23/2016.
 */
@Service
interface PersonService {

    fun create(person: PersonDTO): PersonDTO

    fun delete(id: String): PersonDTO

    fun findAll(): List<PersonDTO>

    fun findById(id: String): PersonDTO

}
