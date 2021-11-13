# Spring R2DBC iClient Example

This is example project for [Spring R2DBC iClient](https://github.com/bhautik008/spring-r2dbc-iclient).

To run this project, please create database `mydb` as per below schema with username as `user` and password as `password. Below table is for MySQL.
<pre>
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `user_phone` varchar(10) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_city` varchar(50) DEFAULT NULL,
  `user_state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT 
</pre>

Insert one record
<pre>
INSERT INTO user (user_name, user_phone, user_address, user_city, user_state) values ('John Dao', '1234567890', '123 Street', 'TestCity', 'TestState');
</pre>

Follow [read.me](https://github.com/bhautik008/spring-r2dbc-iclient/blob/master/README.md) file of Spring R2DBC iClient for how to use.

