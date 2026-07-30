package com.quantumflux.identity.domain

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "mfa_devices")
data class MfaDeviceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity,

    @Column(nullable = false)
    val deviceName: String,

    @Column(nullable = false)
    val secretKey: String,

    @Column(nullable = false)
    var enabled: Boolean = false,

    @Column(nullable = false)
    val enrolledAt: Instant = Instant.now(),

    var lastUsedAt: Instant? = null
)
