package com.carneirofatima.vehicleterminal.controller

import com.carneirofatima.vehicleterminal.InvalidBodyException
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(InvalidBodyException::class)
    fun handlerHttpMessageNotReadableException(
        exception: InvalidBodyException
    ): HttpEntity<Any?> {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
            .body(
                ErrorRespose(
                    listOf(exception.message ?: "Unexpected error")
                )
            )
    }
}