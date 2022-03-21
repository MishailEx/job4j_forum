delete from posts;
delete from users;
delete from authorities;

insert into authorities (id, authority) values (1, 'ROLE_USER');
insert into users (id, username, password, enabled, authority_id) values (1, 'aaa', '123', true, 1);
insert into posts (id, name, description, created) values (1, 'ccc', 'vvv', now());