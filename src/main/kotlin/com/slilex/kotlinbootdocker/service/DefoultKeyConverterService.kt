package com.slilex.kotlinbootdocker.service

import org.springframework.stereotype.Component


@Component
class DefoultKeyConverterService : KeyConverterService {

    val chars ="123456790qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM-_".toCharArray()
    val charToLong = (0..chars.size-1)
            .map {i -> Pair(chars[i], i.toLong()) }
            .toMap()



    override fun idToKey(id: Long): String {
        var n = id
        val builder = StringBuilder()
        while(n != 0L){
            builder.append(chars[(n% chars.size).toInt()])
            n /= chars.size
        }
        return builder.reverse().toString()
    }

    override fun keyToID(key: String) = key
            .map { c -> charToLong[c] !! }
            .fold(0L ,{ a, b -> a* chars.size + b})
}
