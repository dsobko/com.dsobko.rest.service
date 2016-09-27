package com.dsobko.rest.service.objects

import org.springframework.data.annotation.Id

/**
 * Created by dsobko on 09/23/2016.
 */
class Person {

    @Id
    var id: String? = null

    var description: String? = null

    var name: String? = null

}