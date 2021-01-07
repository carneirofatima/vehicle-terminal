package com.carneirofatima.vehicleterminal.controller

import com.carneirofatima.vehicleterminal.ValidationRequest
import com.carneirofatima.vehicleterminal.service.DriverService
import com.carneirofatima.vehicleterminal.to.DriverTO
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/driver")
class DriverController(
    private val service: DriverService,
    private val validator: ValidationRequest
) {

    @PostMapping
    fun save(
       @Valid @RequestBody form: DriverTO
    ): HttpEntity<DriverTO> {
        validator.validateSave(form)
        val response = service.save(form)
        return ResponseEntity.ok(response)
    }

    @PutMapping
    fun edit(
        @Valid @RequestBody form: DriverTO
    ): HttpEntity<DriverTO> {
        validator.validateEdit(form)
        val response = service.save(form)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun getAll(): HttpEntity<List<DriverTO>> {
        val response = service.getAll()
        return ResponseEntity.ok(response)
    }
}