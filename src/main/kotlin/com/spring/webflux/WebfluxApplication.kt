package com.spring.webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class WebfluxApplication

fun main(args: Array<String>) {
    runApplication<WebfluxApplication>(*args)
}
