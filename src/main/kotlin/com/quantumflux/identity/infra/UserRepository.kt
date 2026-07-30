package com.quantumflux.identity.infra

import com.quantumflux.identity.domain.UserEntity
import com.quantumflux.identity.domain.UserStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<UserEntity, String> {
    fun findByEmail(email: String): Optional<UserEntity>?
    fun existsByEmail(email: String): Boolean
    fun findByStatus(status: UserStatus): List<UserEntity>
}
