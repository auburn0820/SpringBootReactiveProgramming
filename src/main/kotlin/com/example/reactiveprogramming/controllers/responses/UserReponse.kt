package com.example.reactiveprogramming.controllers.responses

import com.example.reactiveprogramming.domains.GenderType
import com.example.reactiveprogramming.domains.User
import java.time.LocalDate

data class UserResponse(
    val name: String,
    val gender: GenderType,
    val dateOfBirth: LocalDate
) {
    companion object {
        fun fromUserEntity(user: User): UserResponse {
            return UserResponse(
                name = user.name,
                gender = user.gender,
                dateOfBirth = user.dateOfBirth
            )
        }
    }
}
