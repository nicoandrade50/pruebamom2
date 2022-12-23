package com.example.member.controller

import com.example.member.model.Memberevent
import com.example.member.service.MembereventService
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
@RequestMapping("/memberevent")
class MemberEventController {

    @Autowired
    lateinit var membereventService: MembereventService

    @GetMapping
    fun list():List<Memberevent>{
        return membereventService.list()
    }

    @PostMapping
    fun save(@RequestBody memberevent: Memberevent): Memberevent?{
        return membereventService.save(memberevent)

    }

    @PutMapping
    fun update(@RequestBody memberevent: Memberevent): ResponseEntity<Memberevent> {
        return ResponseEntity(membereventService.update(memberevent), HttpStatus.ACCEPTED)
    }

    @PatchMapping
    fun updateTotal(@RequestBody memberevent: Memberevent): ResponseEntity<Memberevent> {
        return ResponseEntity(membereventService.updateTotal(memberevent), HttpStatus.ACCEPTED)
    }

}
