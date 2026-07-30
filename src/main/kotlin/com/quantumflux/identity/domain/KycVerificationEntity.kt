package com.quantumflux.identity.domain

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "kyc_verifications")
data class KycVerificationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    val user: UserEntity,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val documentType: DocumentType,

    @Column(nullable = false)
    val documentNumber: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var verificationStatus: VerificationStatus = VerificationStatus.PENDING,

    var verifiedAt: Instant? = null,

    var rejectionReason: String? = null,

    val submittedAt: Instant = Instant.now()
)

enum class DocumentType {
    PASSPORT,
    NATIONAL_ID,
    DRIVER_LICENSE,
    RESIDENCE_PERMIT
}

enum class VerificationStatus {
    PENDING,
    UNDER_REVIEW,
    APPROVED,
    REJECTED
}
