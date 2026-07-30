package com.quantumflux.identity.repository

import com.quantumflux.identity.entity.SessionEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SessionRepository : JpaRepository<SessionEntity, String> {
    fun findByUser_Id(userId: String): List<SessionEntity>?
    fun findExpiredSessions(expirationTime: java.time.Instant): List<SessionEntity>?
}
