package dev.minz.batch.reactive.repository.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(
    basePackages = ["dev.minz.batch.reactive.repository"],
    reactiveMongoTemplateRef = "reactiveMongoTemplate",
)
class ReactiveMongoConfiguration {
    @Bean
    fun reactiveMongoTemplate(
        reactiveMongoDatabaseFactory: ReactiveMongoDatabaseFactory,
    ): ReactiveMongoTemplate =
        ReactiveMongoTemplate(reactiveMongoDatabaseFactory)
}
