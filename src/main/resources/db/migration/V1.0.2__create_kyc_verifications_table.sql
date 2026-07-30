-- Migration V1.0.2: Create kyc_verifications table
CREATE TABLE IF NOT EXISTS kyc_verifications (
    id VARCHAR(36) PRIMARY KEY,
    user_id VARCHAR(36) NOT NULL UNIQUE,
    document_type VARCHAR(50) NOT NULL,
    document_number VARCHAR(100) NOT NULL,
    verification_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    verified_at TIMESTAMP,
    rejection_reason TEXT,
    submitted_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_kyc_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_kyc_status ON kyc_verifications(verification_status);
