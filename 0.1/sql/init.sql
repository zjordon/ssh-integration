CREATE DATABASE ssh DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
grant all privileges on ssh.* to ssh@localhost identified by 'ssh';
use ssh;
CREATE TABLE `T_USER` (
`id`  varchar(32) NULL ,
`user_name`  varchar(32) NULL ,
`age`  varchar(32) NULL ,
PRIMARY KEY (`id`)
)
;