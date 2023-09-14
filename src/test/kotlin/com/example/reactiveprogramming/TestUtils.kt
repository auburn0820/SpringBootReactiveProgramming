package com.example.reactiveprogramming

import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ActiveProfiles("test")
@TestConstructor(autowireMode = AutowireMode.ALL)
annotation class BaseTest

@BaseTest
@SpringBootTest
annotation class IntegrationTest

@BaseTest
@DataMongoTest
annotation class MongoRepositoryTest