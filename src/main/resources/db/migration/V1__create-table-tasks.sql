create table tasks(
    id bigint not null auto_increment,
    name varchar(100) not null,
    description varchar(255) not null,
    realized bit not null,
    priority int not null,

    primary key(id)
);