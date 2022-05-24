package dev.minz.batch.reactive.repository.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "dummy_mongo_data")
data class DummyMongoData(
    @Id
    val _id: ObjectId? = null,

    val userId: String,
    val items: Map<String, Any?>,
)
