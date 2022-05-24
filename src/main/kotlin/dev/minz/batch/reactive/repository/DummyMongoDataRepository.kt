package dev.minz.batch.reactive.repository

import dev.minz.batch.reactive.repository.entity.DummyMongoData
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface DummyMongoDataRepository : ReactiveMongoRepository<DummyMongoData, ObjectId> {
    suspend fun findByUserId(userId: String): DummyMongoData?
}
