package com.example.member.model

import java.sql.Time
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="conferencias")
class Conferencias {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)


    var id: Long? = null

    var title :String? = null

    var speaker:String? = null

    var hour:Time? = null

    @Column(name="event_id")

    var eventId:Long? = null

}
