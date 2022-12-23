package com.example.member.repository


import com.example.member.model.Conferencias
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Repository

@Repository


interface ConferenciasRepository:JpaRepository<Conferencias, Long> {
    fun findById(id: Long?): Conferencias



}
