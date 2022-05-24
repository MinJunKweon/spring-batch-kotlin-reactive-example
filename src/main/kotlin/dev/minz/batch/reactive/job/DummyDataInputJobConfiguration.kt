package dev.minz.batch.reactive.job

import dev.minz.batch.reactive.repository.DummyMongoDataRepository
import dev.minz.batch.reactive.repository.entity.DummyMongoData
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DummyDataInputJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {
    private val logger = KotlinLogging.logger { }

    @Bean
    fun dummyDataInputJob(
        @Qualifier("dummyDataInputStep") dummyDataInputStep: Step,
    ): Job =
        jobBuilderFactory["dummyDataInputJob"]
            .start(dummyDataInputStep)
            .build()

    @Bean
    @JobScope
    fun dummyDataInputStep(
        repository: DummyMongoDataRepository,
    ): Step =
        stepBuilderFactory["dummyDataInputJob.input"]
            .chunk<DummyMongoData, String>(1)
            .reader {
                runBlocking {
                    repository.findByUserId("1")
                }
            }
            .processor(
                ItemProcessor {
                    logger.info { it }
                    it.userId
                }
            )
            .writer { }
            .build()
}
