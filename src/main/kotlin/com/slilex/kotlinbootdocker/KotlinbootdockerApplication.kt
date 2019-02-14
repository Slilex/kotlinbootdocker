package com.slilex.kotlinbootdocker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinbootdockerApplication

fun main(args: Array<String>) {
    runApplication<KotlinbootdockerApplication>(*args)
}