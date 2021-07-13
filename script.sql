BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price_id int);
INSERT INTO products (title, price_id) VALUES
('Product 1', 1),
('Product 2', 2),
('Product 3', 3),
('Product 4', 4),
('Product 5', 5);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Customer 1'),
('Customer 2'),
('Customer 3'),
('Customer 4'),
('Customer 5');

DROP TABLE IF EXISTS prices CASCADE;
CREATE TABLE prices (id bigserial PRIMARY KEY, cost double, date date);
INSERT INTO prices (name) VALUES
(100, 01.01.2021),
(200, 01.01.2021),
(300, 01.01.2021),
(400, 01.01.2021),
(500, 01.01.2021);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (id bigserial PRIMARY KEY, date date, cost double, customer_id bigserial, products_id bigserial);
INSERT INTO orders (name) VALUES
(01.01.2021, 100, 1, 1),
(01.01.2021, 200, 2, 2),
(01.01.2021, 300, 3, 3),
(01.01.2021, 400, 4, 4),
(01.01.2021, 500, 5, 5);


COMMIT ;
