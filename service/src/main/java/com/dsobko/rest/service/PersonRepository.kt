package com.dsobko.rest.service

import com.dsobko.rest.service.objects.Person
import org.springframework.data.repository.Repository
import java.util.*

/**
 * Created by dsobko on 09/23/2016.
 */
interface PersonRepository: Repository<Person, String> {
    fun delete(deleted: Person)

    fun findAll(): List<Person>

    fun findOne(id: String): Optional<Person>

    fun save(saved: Person): Person
}