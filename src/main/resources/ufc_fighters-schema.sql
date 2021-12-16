drop table if exists fighter;

create table fighter (id integer not null auto_increment, country varchar(255), division varchar(255), name varchar(255) not null, primary key (id));