-- Migration V1.0.3: Create mfa_devices table
CREATE TABLE IF NOT EXISTS mfa_devices (
    id VARCHAR(36) PRIMARY KEY,
    user_id VARCHAR(36) NOT NULL,
    device_name VARCHAR(100) NOT NULL,
    secret_key VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT false,
    enrolled_at TIMESTAMP NOT NULL DEFAULT NOW(),
    last_used_at TIMESTAMP,
    CONSTRAINT fk_mfa_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_mfa_user_id ON mfa_devices(user_id);
CREATE INDEX idx_mfa_enabled ON mfa_devices(enabled);
