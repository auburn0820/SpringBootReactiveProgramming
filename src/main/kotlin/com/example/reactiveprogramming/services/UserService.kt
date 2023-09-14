package com.example.reactiveprogramming.services

import com.example.reactiveprogramming.controllers.requests.CreateUserRequest
import com.example.reactiveprogramming.domains.User
import com.example.reactiveprogramming.repositories.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(request: CreateUserRequest): Mono<User> {
        return userRepository.save(request.toUserEntity())
    }
}