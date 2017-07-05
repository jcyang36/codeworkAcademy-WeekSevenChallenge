INSERT INTO `joyce`.`role` (`role`) VALUES ('USER');
INSERT INTO `joyce`.`role` (`role`) VALUES ('ADMIN');
INSERT INTO `joyce`.`user` ( `enabled`,  `password`, `username`) VALUES ( TRUE,  'password', 'bob');
INSERT INTO `joyce`.`user` ( `enabled`,  `password`, `username`) VALUES ( TRUE,  'password', 'admin');
INSERT INTO `joyce`.`user` ( `enabled`,  `password`, `username`) VALUES (TRUE, 'password', 'everyman');
INSERT INTO `joyce`.`user_roles` (`user_id`, `role_id`) VALUES ('4', '1');
INSERT INTO `joyce`.`user_roles` (`user_id`, `role_id`) VALUES ('5', '2');

select * from  user;