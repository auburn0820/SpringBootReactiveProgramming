package com.example.reactiveprogramming.domains

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Document("user")
class User(
        @MongoId
        val id: String = UUID.randomUUID().toString(),
        val name: String,
        val dateOfBirth: Date,
        val gender: GenderType,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val updatedAt: LocalDateTime = LocalDateTime.now()
)

enum class GenderType {
        MALE,
        FEMALE
}