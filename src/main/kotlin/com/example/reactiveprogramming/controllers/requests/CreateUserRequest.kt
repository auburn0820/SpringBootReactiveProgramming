package com.example.reactiveprogramming.controllers.requests

import com.example.reactiveprogramming.domains.GenderType
import com.example.reactiveprogramming.domains.User
import java.time.LocalDate

data class CreateUserRequest(
    val name: String,
    val gender: GenderType,
    val dateOfBirth: LocalDate
) {
    fun toUserEntity(): User {
        return User(
            name = name,
            gender = gender,
            dateOfBirth = dateOfBirth
        )
    }
}