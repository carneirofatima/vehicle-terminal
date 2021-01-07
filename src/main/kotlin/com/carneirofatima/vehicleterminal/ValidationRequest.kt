package com.carneirofatima.vehicleterminal

import com.carneirofatima.vehicleterminal.dao.DriverDao
import com.carneirofatima.vehicleterminal.to.DriverTO
import org.springframework.stereotype.Component

@Component
class ValidationRequest(
    private val dao: DriverDao
) {

    fun validateEdit(form: DriverTO) {
        if (form.driverId == 0) {
            throw InvalidBodyException("Select a registered driver to continue.")
        } else if (!dao.existsById(form.driverId)) {
            throw InvalidBodyException("Driver not found.")
        }
    }

    fun validateSave(form: DriverTO) {
        val register = dao.findByRegister(form.register)
        if (!register.isNullOrEmpty()) {
            throw InvalidBodyException("This record is already in the system and cannot be added again.")
        }
    }
}