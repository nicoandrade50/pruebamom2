package com.example.member.repository


import com.example.member.model.Memberevent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository


interface MemberEventRepository:JpaRepository<Memberevent, Long> {
    fun findById(id: Long?): Memberevent?


}
