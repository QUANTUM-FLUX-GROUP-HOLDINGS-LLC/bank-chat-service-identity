package com.quantumflux.identity.repository

import com.quantumflux.identity.entity.MfaDeviceEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MfaDeviceRepository : JpaRepository<MfaDeviceEntity, String> {
    fun findByUser_Id(userId: String): List<MfaDeviceEntity>?
    fun findByUser_IdAndEnabledTrue(userId: String): List<MfaDeviceEntity>?
}
