package com.spring.webflux.application

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author Youngjin Hong
 */

@Component
class MultiThreadService {
    private val logger = LoggerFactory.getLogger(javaClass)

    suspend fun suspend() {
        logger.info("SUSPEND START")
        delay(1000)
        logger.info("SUSPEND END")
    }

    suspend fun block() {
        logger.info("BLOCK START")
        Thread.sleep(1000)
        logger.info("BLOCK END")
    }

    suspend fun blockWithContext() {
        logger.info("BLOCK WITH CONTEXT START")
        withContext(boundedElasticDispatcher) {
            Thread.sleep(1000)
        }

        logger.info("BLOCK WITH CONTEXT END")
    }
}
