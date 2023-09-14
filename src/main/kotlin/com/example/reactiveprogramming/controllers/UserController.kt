package com.example.reactiveprogramming.controllers

import com.example.reactiveprogramming.controllers.requests.CreateUserRequest
import com.example.reactiveprogramming.controllers.responses.UserResponse
import com.example.reactiveprogramming.services.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1.0/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(request: CreateUserRequest): Mono<UserResponse> {
        return userService.createUser(request)
            .map {
                UserResponse.fromUserEntity(it)
            }
    }
}