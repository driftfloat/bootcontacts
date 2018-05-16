create table contacts (
	id identity,
	firstName varchar(30) not null,
	lastName varchar(50) not null,
	phoneNumber varchar(13),
	emailAddress varchar(30)
);

insert into contacts(firstName, lastName, phoneNumber, emailAddress ) 
	values('firstName', 'lastName', 'phoneNumber', 'emailAddress');