package com.example.reactiveprogramming.repositories

import com.example.reactiveprogramming.domains.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface UserRepository: ReactiveMongoRepository<User, String> {
}