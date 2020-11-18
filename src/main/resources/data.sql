ALTER TABLE user_book
    ADD CONSTRAINT fk1 FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE user_book
    ADD CONSTRAINT fk2 FOREIGN KEY (book_id) REFERENCES book (id);

insert into user (username, password, firstname, lastname)
values ('admin1',
        '$2a$10$mjDa4FQ0PZAf21xCFkyIau65FM0JBIUW7VFkwYKuIRUXLQwBcY8TK', 'first', 'last');

insert into user (username, password, firstname, lastname)
values ('admin2',
        '$2a$10$mjDa4FQ0PZAf21xCFkyIau65FM0JBIUW7VFkwYKuIRUXLQwBcY8TK', 'first', 'last');


insert into book (author, name, ISBN, created, status)
values ('author1', 'name1', '1234567890987', CURRENT_TIMESTAMP, false);

insert into book (author, name, ISBN, created, status)
values ('author2', 'name2', '1544567890987', CURRENT_TIMESTAMP, false);

insert into book (author, name, ISBN, created, status)
values ('author3', 'name3', '1544567890988', CURRENT_TIMESTAMP, false);

insert into book (author, name, ISBN, created, status)
values ('author4', 'name4', '1234567890927', CURRENT_TIMESTAMP, false);

insert into book (author, name, ISBN, created, status)
values ('author5', 'name5', '1234547891927', CURRENT_TIMESTAMP, false);

insert into book (author, name, ISBN, created)
values ('author6', 'name6', '1634547890927', CURRENT_TIMESTAMP);
insert into book (author, name, ISBN, created)
values ('author7', 'name7', '1734547890927', CURRENT_TIMESTAMP);

insert into user_book(user_id, book_id, status)
values (0, 0, true);
insert into user_book(user_id, book_id, status)
values (0, 1, false);
insert into user_book(user_id, book_id, status)
values (0, 2, true);
insert into user_book(user_id, book_id, status)
values (1, 0, false);
insert into user_book(user_id, book_id, status)
values (1, 1, true);
insert into user_book(user_id, book_id, status)
values (1, 2, false);


