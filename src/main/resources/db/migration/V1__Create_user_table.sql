CREATE SCHEMA hotel;

CREATE TABLE IF NOT EXISTS hotel.user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);
