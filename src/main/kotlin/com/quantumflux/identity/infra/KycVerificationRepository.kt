package com.quantumflux.identity.infra

import com.quantumflux.identity.domain.KycVerificationEntity
import com.quantumflux.identity.domain.VerificationStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface KycVerificationRepository : JpaRepository<KycVerificationEntity, String> {
    fun findByUser_Id(userId: String): Optional<KycVerificationEntity>?
    fun findByVerificationStatus(status: VerificationStatus): List<KycVerificationEntity>
}
