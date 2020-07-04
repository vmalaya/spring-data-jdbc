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
