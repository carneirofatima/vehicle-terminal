package com.carneirofatima.vehicleterminal.entity

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Driver(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var driverId: Int,

    @JsonProperty("register")
    var register: String,

    @JsonProperty("name")
    var name: String,

    @JsonProperty("qualification")
    var qualification: String,

    var haveVehicle: Boolean,

    var isLoaded: Boolean
)