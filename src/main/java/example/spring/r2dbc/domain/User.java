package example.spring.r2dbc.domain;

import lombok.Data;

@Data
public class User {
	private Integer userId;
	private String userName;
	private String userPhone;
	private UserAddress userAddress;
}
