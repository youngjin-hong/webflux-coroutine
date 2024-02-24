package com.spring.webflux.presentation.router

import com.spring.webflux.presentation.handler.MultiThreadHandler
import com.spring.webflux.presentation.handler.SingleThreadHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

/**
 * @author Youngjin Hong
 */

@Configuration
class ThreadRouter(
    private val singleThreadHandler: SingleThreadHandler,
    private val multiThreadHandler: MultiThreadHandler,
) {
    @Bean
    fun routerFunction(): RouterFunction<ServerResponse> {
        return coRouter {
            GET("/single/suspend", singleThreadHandler::suspend)
            GET("/single/block", singleThreadHandler::block)
            GET("/single/block/withcontext", singleThreadHandler::blockWithContext)
            GET("/multi/suspend", multiThreadHandler::suspend)
            GET("/multi/block", multiThreadHandler::block)
            GET("/multi/block/withcontext", multiThreadHandler::blockWithContext)
        }
    }
}
