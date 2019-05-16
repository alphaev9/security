insert into users(username,password,enabled) values('user1','123',true);
insert into users(username,password,enabled) values('user2','123',true);

insert into authorities(username,authority) values('user1','ROLE_USER');
insert into authorities(username,authority) values('user2','ROLE_USER');
insert into authorities(username,authority) values('user2','ROLE_EDITOR');