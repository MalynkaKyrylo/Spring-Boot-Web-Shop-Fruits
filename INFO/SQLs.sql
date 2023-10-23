CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS fruits
( id INTEGER NOT NULL AUTO_INCREMENT,
  img VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  article VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
( id INTEGER NOT NULL AUTO_INCREMENT,
  order_code VARCHAR(255) NOT NULL,
  buyer_name VARCHAR(255) NOT NULL,
  buyer_phone VARCHAR(255) NOT NULL,
  buyer_email VARCHAR(255) NOT NULL,
  content VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO
 fruits (img, name, article, description, price)
VALUES
 ('fruit-apple.jpg', 'Apples', 'frt-0001', 'Apples Ukraine Honey Crisp', 1.50),
 ('fruit-banana.jpg', 'Bananas', 'frt-0002', 'Bananas Brazil', 0.75),
 ('fruit-grapefruit.jpg', 'Grapefruits', 'frt-0003', 'Grapefruits Caribbeans', 2.50),
 ('fruit-mango.jpg', 'Mangoes', 'frt-0004', 'Mangoes Egypt', 3.00),
 ('fruit-oranges.jpg', 'Oranges', 'frt-0005', 'Oranges Spain', 2.20),
 ('fruit-pineapples.jpg', 'Pineapples', 'frt-0006', 'Pineapples Costa-Rica', 4.50),
 ('fruit-pomegranate.jpg', 'Pomegranate', 'frt-0007', 'Pomegranate Georgia', 2.10),
 ('fruit-white_grape.jpg', 'White Grape', 'frt-0008', 'White Grape Ukraine', 1.20);

SELECT * FROM products;

DELETE FROM products WHERE id = :id;

SELECT * FROM orders;

DELETE FROM orders WHERE id = :id;
