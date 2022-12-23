package com.example.member.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="memberevent")
class Memberevent {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null

    @Column(name="member_id")

    var memberId:Long? = null

    @Column(name="event_id")


    var eventId:Long? = null

}
