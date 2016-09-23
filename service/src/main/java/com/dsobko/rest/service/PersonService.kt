package com.dsobko.rest.service

/**
 * Created by dsobko on 09/23/2016.
 */
interface PersonService {

    fun create(person: PersonDTO): PersonDTO

    fun delete(id: String): PersonDTO

    fun findAll(): List<PersonDTO>

    fun findById(id: String): PersonDTO

    fun update(person: PersonDTO): PersonDTO

}
