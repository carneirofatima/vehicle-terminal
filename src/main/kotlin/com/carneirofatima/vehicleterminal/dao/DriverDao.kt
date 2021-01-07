package com.carneirofatima.vehicleterminal.dao

import com.carneirofatima.vehicleterminal.entity.Driver
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DriverDao : JpaRepository<Driver, Int> {

    @Query(value = "SELECT register FROM Driver d WHERE d.register = :register")
    fun findByRegister(register: String?): List<String?>?
}