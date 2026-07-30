-- Migration V1.0.0: Create users table
CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(36) PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    tenant_context VARCHAR(50) DEFAULT 'personales',
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING_VERIFICATION',
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_users_email ON users(email);

CREATE INDEX idx_users_status ON users(status);
