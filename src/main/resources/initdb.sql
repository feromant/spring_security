INSERT INTO roles (role) VALUES ('ROLE_ADMIN'), ('ROLE_USER');
INSERT INTO users (name, last_name, age, email, password)
VALUES ('admin', 'admin', 45, 'admin@test.gmail',
        '$2a$12$oB9AdrYT0eKA4xSmRruiMOtMfyqA.mP3RYWymgo6uZC2rR7Wp85Lq');
INSERT INTO users_roles VALUES (1,1);