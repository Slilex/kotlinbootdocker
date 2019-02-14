package com.slilex.kotlinbootdocker.service

interface KeyConverterService {
    fun idToKey(id: Long): String

    fun keyToID(key: String): Long

}
