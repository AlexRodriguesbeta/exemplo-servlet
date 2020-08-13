CREATE DATABASE dbteste2;

CREATE TABLE tbcliente(
idCliente int(4) AUTO_INCREMENT,
nome varchar(30) NOT NULL,
endereco varchar(40),
cpf varchar (14),
data_nascimento varchar (10),
PRIMARY KEY (idCliente)
);

SELECT * FROM `tbcliente`;