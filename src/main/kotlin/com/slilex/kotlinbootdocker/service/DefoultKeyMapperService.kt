package com.slilex.kotlinbootdocker.service

import java.util.concurrent.ConcurrentHashMap


class DefoultKeyMapperService : KeyMapperService {

    private val map: MutableMap<String, String> = ConcurrentHashMap()


    override fun add(key: String, link: String): KeyMapperService.Add {
       if(map.contains(key)) {
           return KeyMapperService.Add.AlreadyExist(key)
       }else{
           map.put(key, link)
           return KeyMapperService.Add.Succes(key, link)
       }
    }

    override fun getLink(key: String) = if(map.contains(key)) {
        KeyMapperService.Get.Link(map.get(key)!!)
    }else{
        KeyMapperService.Get.NotFound(key)
    }
}
