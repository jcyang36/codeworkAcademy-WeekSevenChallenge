INSERT INTO `resumeOne`.`role` (`role`) VALUES ('USER');
INSERT INTO `resumeOne`.`role` (`role`) VALUES ('ADMIN');
INSERT INTO `resumeOne`.`user` (`email`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES ('bob@bob.com', TRUE, 'Bob', 'Bobberson', 'password', 'bob');
INSERT INTO `resumeOne`.`user` (`email`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES ('admin@bob.com', TRUE, 'Admin', 'User', 'password', 'admin');
INSERT INTO `resumeOne`.`user` (`email`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES ('every@bob.com', TRUE, 'Every', 'User', 'password', 'everyman');
INSERT INTO `resumeOne`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `resumeOne`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `resumeOne`.`user_roles` (`user_id`, `role_id`) VALUES ('3', '1');
INSERT INTO `resumeOne`.`user_roles` (`user_id`, `role_id`) VALUES ('3', '2');
select * from user;