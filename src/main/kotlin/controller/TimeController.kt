package es.unizar.webeng.lab2.controller

import es.unizar.webeng.lab2.TimeDTO
import es.unizar.webeng.lab2.TimeProvider
import es.unizar.webeng.lab2.toDTO

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TimeController(private val service: TimeProvider) {
    
    @GetMapping("/time")
    fun time(): TimeDTO = service.now().toDTO()
}
