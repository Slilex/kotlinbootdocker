package com.slilex.kotlinbootdocker.service

import org.junit.Assert.*
import org.junit.Test

class DefoultKeyMapperServiceTest{
    val service: KeyMapperService = DefoultKeyMapperService()

    private val KEY: String = "abcdef"
    private val LINK_NEW: String = "http://wow.ru"
    private val LINK: String = "https://www.eveonline.com/"

    @Test
    fun clientCanAddNewKeyWithLink(){
        assertEquals(KeyMapperService.Add.Succes(KEY, LINK),service.add(KEY,LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }


    @Test

    fun clientCanNotAddExistingKey(){
        service.add(KEY, LINK)
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY),service.add(KEY,LINK_NEW))
        assertEquals(KeyMapperService.Get.Link(LINK),service.getLink(KEY))
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService(){
        assertEquals(KeyMapperService.Get.NotFound(KEY),service.getLink(KEY))
    }
}