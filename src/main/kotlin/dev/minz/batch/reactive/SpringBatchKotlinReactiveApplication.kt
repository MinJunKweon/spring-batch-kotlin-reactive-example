package dev.minz.batch.reactive

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class SpringBatchKotlinReactiveApplication

fun main(args: Array<String>) {
    runApplication<SpringBatchKotlinReactiveApplication>(*args)
}
