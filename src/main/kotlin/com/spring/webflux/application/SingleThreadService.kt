package com.spring.webflux.application

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import reactor.core.scheduler.Schedulers

/**
 * @author Youngjin Hong
 */

@Component
class SingleThreadService {
    private val logger = LoggerFactory.getLogger(javaClass)

    suspend fun suspend() { //1.2초
        logger.info("SUSPEND START")
        delay(1000) // 코루틴 일시중단
        logger.info("SUSPEND END")
    }

    suspend fun block() { // 50 초 > 코루틴  > 일시중단
        logger.info("BLOCK START")
        Thread.sleep(1000) // 쓰레드 block
        logger.info("BLOCK END")
    }

    suspend fun blockWithContext() {
        logger.info("BLOCK WITH CONTEXT START") // 1.8초
        withContext(boundedElasticDispatcher) {
            logger.info("WITH CONTEXT ING") // 1.8초
            Thread.sleep(1000)
        }

        logger.info("BLOCK WITH CONTEXT END")
    }
}
