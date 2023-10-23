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
 ('t-shirt-orange.jpg', 'T-shirt orange', 'TSO3214', 'Lorem ipsum orange', 27.95),
 ('t-shirt-blue.jpg', 'T-shirt blue', 'TSB3255', 'Lorem ipsum blue', 25.95),
 ('t-shirt-green.jpg', 'T-shirt green', 'TSG3209', 'Lorem ipsum green', 19.99),
 ('t-shirt-black.jpg', 'T-shirt black', 'TSB3200', 'Lorem ipsum black', 19.99),
 ('t-shirt-yellow.jpg', 'T-shirt yellow', 'TSY3222', 'Lorem ipsum yellow', 20.95);

