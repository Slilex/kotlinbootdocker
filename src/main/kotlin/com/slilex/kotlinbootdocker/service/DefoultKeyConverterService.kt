package com.slilex.kotlinbootdocker.service

class DefoultKeyConverterService : KeyConverterService {

    val chars ="123456790qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM-_".toCharArray()



    override fun idToKey(id: Long): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun keyToID(key: String): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
