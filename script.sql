BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES
('Product 1', 100),
('Product 2', 200),
('Product 3', 300),
('Product 4', 400),
('Product 5', 500);
COMMIT ;