package com.spring.webflux.application

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.reactor.asCoroutineDispatcher
import reactor.core.scheduler.Schedulers

/**
 * @author Youngjin Hong
 */

/**
 *  DEFAULT_BOUNDED_ELASTIC_SIZE = core * 10
 */
val boundedElasticDispatcher = Schedulers.boundedElastic()
    .asCoroutineDispatcher() + CoroutineName("elastic")
