create database usersDB;

use usersDB;

-------------------------
-------------------------

create table users(
id bigint not null auto_increment,
email varchar(50) not null,
senha varchar(50) not null,
idade int not null,
nome varchar(50) not null,
tipo varchar(20) not null,

primary key (id)
);

-------------------------
-------------------------

insert into users (email, senha, idade, nome, tipo) 
values("admin123@gmail.com", "adm123", "20", "Daniel", "Administrador");

select * from users;