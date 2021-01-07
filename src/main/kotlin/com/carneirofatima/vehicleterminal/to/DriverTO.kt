package com.carneirofatima.vehicleterminal.to

import com.sun.istack.NotNull

data class DriverTO(
    var driverId: Int,

    var name: String,

    var isLoaded: Boolean,

    var haveVehicle: Boolean,

    @NotNull
    var register: String,

    @NotNull
    var qualification: String
)