create table if not exists company(
    id integer primary key,
    name varchar(100) null
);

create table if not exists user(
    id integer primary key,
	company integer references company(id),
	name varchar(100) null,
	password varchar(100) null
);

create table if not exists address(
    id integer primary key ,
    country varchar(100) null ,
    city varchar(100) null,
    street varchar(100) null,
    user integer references user(id)
);
