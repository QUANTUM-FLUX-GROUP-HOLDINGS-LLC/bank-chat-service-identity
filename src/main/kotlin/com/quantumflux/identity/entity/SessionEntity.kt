package com.quantumflux.identity.domain

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "sessions")
data class SessionEntity(
    @Id
    val token: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity,

    @Column(nullable = false)
    val expiresAt: Instant,

    @Column(nullable = false)
    var mfaVerified: Boolean = false,

    @Column(nullable = false)
    val createdAt: Instant = Instant.now(),

    var revokedAt: Instant? = null
)
