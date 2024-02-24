package com.spring.webflux.presentation.handler

import com.spring.webflux.application.MultiThreadService
import com.spring.webflux.application.SingleThreadService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait

/**
 * @author Youngjin Hong
 */

@Component
class MultiThreadHandler(
    private val multiThreadService: MultiThreadService,
) {
    private val threadPool = newFixedThreadPoolContext(10, "MultiThread")

    suspend fun suspend(request: ServerRequest): ServerResponse = withContext(threadPool) {
        multiThreadService.suspend()
        ServerResponse.noContent().buildAndAwait()
    }

    suspend fun block(request: ServerRequest): ServerResponse = withContext(threadPool) {
        multiThreadService.block()
        ServerResponse.noContent().buildAndAwait()
    }

    suspend fun blockWithContext(request: ServerRequest): ServerResponse = withContext(Dispatchers.IO) {
        multiThreadService.blockWithContext()
        ServerResponse.noContent().buildAndAwait()
    }
}
