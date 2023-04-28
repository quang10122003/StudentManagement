create database student_management;
use student_management;

CREATE TABLE admin(
	id int NOT NULL AUTO_INCREMENT,
    username varchar(45) NOT NULL,
    password varchar(45) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE student(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(150) NOT NULL,
	date_of_birth date NOT NULL,
	gender varchar(10) NOT NULL,
	email varchar(100) NOT NULL,
	phone varchar(15) NOT NULL,
	father_name varchar(150) NOT NULL,
	mother_name varchar(150) NOT NULL,
	address1 text NOT NULL,
	address2 text NOT NULL,
	image_path varchar(200) NOT NULL,
	PRIMARY KEY (id)
);

