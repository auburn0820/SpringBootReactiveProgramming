package com.example.reactiveprogramming.repositories

import com.example.reactiveprogramming.MongoRepositoryTest
import com.example.reactiveprogramming.domains.GenderType
import com.example.reactiveprogramming.domains.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

@MongoRepositoryTest
class UserRepositoryTest(
    private val userRepository: UserRepository
) {
    @Test
    fun `저장 메소드를 호출하면 MongoDB에 저장된다`() {
        // given
        val user = User(
            name = "김덕배",
            dateOfBirth = LocalDate.of(1991, 6, 28),
            gender = GenderType.MALE
        )

        // when
        userRepository.save(user).block()

        // then
        val userOfDB = userRepository.findAll().blockFirst()!!

        assertThat(userOfDB.id).isEqualTo(user.id)
        assertThat(userOfDB.name).isEqualTo(user.name)
        assertThat(userOfDB.gender).isEqualTo(user.gender)
    }
}