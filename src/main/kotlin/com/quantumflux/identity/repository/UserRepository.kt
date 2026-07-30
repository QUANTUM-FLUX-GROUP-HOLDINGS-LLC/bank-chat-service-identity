package com.quantumflux.identity.repository

import com.quantumflux.identity.entity.UserEntity
import com.quantumflux.identity.entity.UserStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<UserEntity, String> {
    fun findByEmail(email: String): Optional<UserEntity>?
    fun existsByEmail(email: String): Boolean
    fun findByStatus(status: UserStatus): List<UserEntity>
}
