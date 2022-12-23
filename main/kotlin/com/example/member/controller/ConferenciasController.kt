package com.example.member.controller

import com.example.member.model.Conferencias
import com.example.member.service.ConferenciasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/conferencias")
class ConferenciasController {

    @Autowired
    lateinit var conferenciasService: ConferenciasService

    @GetMapping
    fun list():List<Conferencias>{
        return conferenciasService.list()
    }


    @PostMapping
    fun save(@RequestBody conferencias: Conferencias): Conferencias?{
        return conferenciasService.save(conferencias)

    }

    @PutMapping
    fun update(@RequestBody conferencias: Conferencias): ResponseEntity<Conferencias> {
        return ResponseEntity(conferenciasService.update(conferencias), HttpStatus.ACCEPTED)
    }

    @PatchMapping
    fun updateTotal(@RequestBody conferencias: Conferencias): ResponseEntity<Conferencias> {
        return ResponseEntity(conferenciasService.updateTotal(conferencias), HttpStatus.ACCEPTED)
    }

}