package com.quantumflux.identity.domain

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val passwordHash: String,

    @Column(nullable = false)
    val tenantContext: String = "personal",

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: UserStatus = UserStatus.PENDING_VERIFICATION,

    @Column(nullable = false)
    val createdAt: Instant = Instant.now(),

    var firstName: String? = null,
    var lastName: String? = null
)

enum class UserStatus {
    PENDING_VERIFICATION,
    ACTIVE,
    SUSPENDED,
    DEACTIVATED
}
