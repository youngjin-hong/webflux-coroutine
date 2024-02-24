package com.spring.webflux.presentation.handler

import com.spring.webflux.application.SingleThreadService
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import reactor.core.scheduler.Schedulers

/**
 * @author Youngjin Hong
 */

@Component
class SingleThreadHandler(
    private val singleThreadService: SingleThreadService,
) {
    private val logger = LoggerFactory.getLogger(javaClass)
    private val threadPool = newSingleThreadContext("SingleThread")

    suspend fun suspend(request: ServerRequest): ServerResponse = withContext(threadPool) {
        logger.info("HANDLER INIT")
        singleThreadService.suspend()
        ServerResponse.noContent().buildAndAwait()
    }

    suspend fun block(request: ServerRequest): ServerResponse = withContext(threadPool) {
        logger.info("HANDLER INIT")
        singleThreadService.block()
        ServerResponse.noContent().buildAndAwait()
    }

    suspend fun blockWithContext(request: ServerRequest): ServerResponse = withContext(threadPool) {
        logger.info("HANDLER INIT")
        singleThreadService.blockWithContext()
        ServerResponse.noContent().buildAndAwait()
    }
}
