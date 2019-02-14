package com.slilex.kotlinbootdocker.service

import org.junit.Test
import java.util.*
import org.junit.Assert.*

class DefoultKeyConverterServiceTest{

    val service: KeyConverterService = DefoultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays(){
        val rand = Random()
        for (i in 0..1000L){
            val initialId = Math.abs(rand.nextLong())
            val key = service.idToKey(initialId)
            val id = service.keyToID(key)

            assertEquals(initialId,id)

        }
    }

}