drop table if exists book CASCADE;
drop table if exists user CASCADE;
drop table if exists user_book CASCADE;

CREATE TABLE user
(
    id identity primary key not null,
    username varchar(2000) unique,
    password  varchar(2000),
    firstname varchar(2000),
    lastname  varchar(2000)
);

CREATE TABLE book
(
    id identity primary key not null,
    author  varchar(2000),
    name    varchar(2000),
    ISBN    varchar(2000),
    created TIMESTAMP default now,
    status  BOOLEAN   default true,
    user_id bigint,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE user_book
(
    user_id bigint not null,
    book_id bigint not null,
    status  BOOLEAN default true
);