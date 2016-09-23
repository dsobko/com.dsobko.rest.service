package com.dsobko.rest.service


import org.hibernate.validator.constraints.NotEmpty
import javax.validation.constraints.Size

/**
 * Created by dsobko on 09/23/2016.
 */
class PersonDTO() {

    companion object {
        const val MAX_LENGTH_DESCRIPTION = 500
        const val MAX_LENGTH_NAME = 100
    }


    var id: String? = null

    @Size(max = MAX_LENGTH_DESCRIPTION)
    var description: String? = null

    @NotEmpty
    @Size(max = MAX_LENGTH_NAME)
    var name: String? = null
}