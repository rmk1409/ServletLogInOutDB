DROP TABLE IF EXISTS login_app;
DROP SEQUENCE IF EXISTS seq_for_login_id;

CREATE SEQUENCE seq_for_login_id;
CREATE TABLE IF NOT EXISTS "login_app" (
  "id" integer PRIMARY KEY default nextval('seq_for_login_id'),
  "login" varchar(30) NOT NULL UNIQUE,
  "password" varchar(30) NOT NULL,
  "info_1" varchar(30) DEFAULT NULL,
  "info_2" varchar(30) DEFAULT NULL,
  "info_3" varchar(30) DEFAULT NULL
);

INSERT into login_app(login, password, info_1, info_2, info_3) values ('Ivan', 'PassIvan', 'Rus', 'jogging', 'relax-music');
INSERT into login_app(login, password, info_1, info_2, info_3) values ('Rmk', 'PassRmk', 'Rus', 'swimming', 'no more any interests');
INSERT into login_app(login, password, info_1, info_2, info_3) values ('Alex', 'PassAlex', 'USA', 'money', 'freedom');
INSERT into login_app(login, password, info_1, info_2, info_3) values ('Sala', 'PassSala', 'Europe', 'cars', 'boys');