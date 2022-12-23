package com.example.member.service

import com.example.member.model.Conferencias
import com.example.member.repository.ConferenciasRepository
import com.example.member.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException



@Service
class ConferenciasService {
    @Autowired
    lateinit var conferenciasRepository: ConferenciasRepository
    
    @Autowired
    lateinit var memberRepository: MemberRepository


    fun list ():List<Conferencias>{
        return conferenciasRepository.findAll()
    }

    fun save (conferencias: Conferencias):Conferencias{
        try{
            memberRepository.findById(conferencias.eventId)
                ?:throw Exception("El id ${conferencias.eventId} de member no existe")
            return conferenciasRepository.save(conferencias)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun update(conferencias: Conferencias):Conferencias{
        try {
            conferenciasRepository.findById(conferencias.id)
                ?: throw Exception("El id ${conferencias.id} en factura no existe")
            return conferenciasRepository.save(conferencias)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateTotal(conferencias: Conferencias):Conferencias{
        try{
            val response = conferenciasRepository.findById(conferencias.id)
                ?:throw Exception("El ${conferencias.id} en factura no existe")

            response.apply{
                title = conferencias.title
            }
            return conferenciasRepository.save(response)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)

        }
    }
}
