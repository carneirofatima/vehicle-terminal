package com.carneirofatima.vehicleterminal.service

import com.carneirofatima.vehicleterminal.dao.DriverDao
import com.carneirofatima.vehicleterminal.entity.Driver
import com.carneirofatima.vehicleterminal.to.DriverTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DriverService(
    private val dao: DriverDao
) {

    @Transactional
    fun save(form: DriverTO): DriverTO {
        val driver: Driver = form.toEntity()
        dao.save(driver)
        return driver.toForm()
    }

    private fun DriverTO.toEntity(): Driver {
        return Driver(driverId, register, name, qualification, haveVehicle, isLoaded)
    }

    private fun Driver.toForm(): DriverTO {
        return DriverTO(driverId, name, isLoaded, haveVehicle, register, qualification)
    }

    fun getAll(): List<DriverTO> {
        val drivers = ArrayList<DriverTO>()
        dao.findAll().forEach {
            val driver = it.toForm()
            drivers.add(driver)
        }

        return drivers
    }
}