
package com.example.member.service

import com.example.member.model.Memberevent
import com.example.member.repository.MemberEventRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
@Service
class MembereventService {
    @Autowired
    lateinit var membereventRepository: MemberEventRepository



    fun list ():List<Memberevent>{
        return membereventRepository.findAll()
    }


    fun save (memberevent: Memberevent):Memberevent{
        return membereventRepository.save(memberevent)
    }
    fun update(memberevent: Memberevent):Memberevent{
        try {
            membereventRepository.findById(memberevent.id)
                ?: throw Exception("El id ${memberevent.id} en detalle no existe")
            return membereventRepository.save(memberevent)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateTotal(memberevent: Memberevent):Memberevent{
        try{
            val response = membereventRepository.findById(memberevent.id)
                ?:throw Exception("El ${memberevent.id} en detalle no existe")
            response.apply{
                id = memberevent.id
            }
            return membereventRepository.save(response)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)

        }
    }

}
