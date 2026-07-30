package com.quantumflux.identity.repository

import com.quantumflux.identity.entity.KycVerificationEntity
import com.quantumflux.identity.entity.VerificationStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface KycVerificationRepository : JpaRepository<KycVerificationEntity, String> {
    fun findByUser_Id(userId: String): Optional<KycVerificationEntity>?
    fun findByVerificationStatus(status: VerificationStatus): List<KycVerificationEntity>
}
