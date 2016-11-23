package com.dsobko.rest.service

import com.dsobko.rest.service.objects.Person
import org.springframework.data.repository.CrudRepository

/**
 * Created by dsobko on 09/23/2016.
 */
interface PersonRepository: CrudRepository<Person, String> {

    override fun delete(deleted: Person)

    override fun findAll(): List<Person>

    override fun findOne(id: String): Person

    override fun <S : Person?> save(entity: S): S

}