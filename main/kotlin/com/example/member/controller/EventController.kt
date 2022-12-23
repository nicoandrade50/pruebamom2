package com.example.member.controller


import com.example.member.model.Event
import com.example.member.service.EventService
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
@RequestMapping("/event")
class EventController {

    @Autowired
    lateinit var eventService: EventService

    @GetMapping
    fun list():List<Event>{
        return eventService.list()
    }

    @PostMapping
    fun save(@RequestBody event: Event): Event?{
        return eventService.save(event)

    }

    @PutMapping
    fun update(@RequestBody event: Event): ResponseEntity<Event> {
        return ResponseEntity(eventService.update(event), HttpStatus.ACCEPTED)
    }

    @PatchMapping
    fun updateTotal(@RequestBody event: Event): ResponseEntity<Event> {
        return ResponseEntity(eventService.updateTotal(event), HttpStatus.ACCEPTED)
    }


}