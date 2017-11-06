create schema PosDM107;
use PosDM107;

create table entregas (
	id int not null primary key auto_increment,
    nPedido int not null,
    idCliente int not null,
    nome varchar(500) not null,
    cpf varchar(11) not null,
    dataHoraEntrega varchar(30) not null


);
create table Usuario(
	id int not null primary key auto_increment,
	usuario varchar(500) not null,
    senha varchar(500) not null
);