package example.spring.r2dbc.repository;

import java.util.Map;

import org.reactive.r2dbc.iclient.annotation.Insert;
import org.reactive.r2dbc.iclient.annotation.Param;
import org.reactive.r2dbc.iclient.annotation.PropertyMapper;
import org.reactive.r2dbc.iclient.annotation.R2dbcMapper;
import org.reactive.r2dbc.iclient.annotation.Result;
import org.reactive.r2dbc.iclient.annotation.ResultMap;
import org.reactive.r2dbc.iclient.annotation.Results;
import org.reactive.r2dbc.iclient.annotation.Select;
import org.reactive.r2dbc.iclient.annotation.Update;

import example.spring.r2dbc.domain.User;
import example.spring.r2dbc.domain.UserAddress;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@R2dbcMapper
public interface UserRepository {
	
	@Select("select * from user")
	public Flux<Map<String, Object>> getAllMap();

	@Results(id = "userMap", type = User.class, value = {
			@Result(property = "userId", column = "user_id", javaType = Integer.class),
			@Result(property = "userName", column = "user_name", javaType = String.class),
			@Result(property = "userPhone", column = "user_phone", javaType = String.class),
			@Result(property = "userAddress", javaType = UserAddress.class, resultMap = "userAddressMap") })
	@Select("select * from user")
	public Flux<User> getAll();

	@Results(id = "userAddressMap", type = UserAddress.class, value = {
			@Result(property = "userAddress", column = "user_address", javaType = String.class),
			@Result(property = "userCity", column = "user_city", javaType = String.class),
			@Result(property = "userState", column = "user_state", javaType = String.class) })
	@Select("select * from user")
	public Flux<UserAddress> getUserAddress();

	@ResultMap("userMap")
	@Select("select * from user where user_id = :userId")
	public Mono<User> getUserById(@Param("userId") Integer userId);

	@Update(value = "update user set user_name = :user.userName where user_id = :user.userId", propertyMapper = {
			@PropertyMapper(javaType = String.class, properties = "user.userName"),
			@PropertyMapper(javaType = Integer.class, properties = "user.userId") })
	public Mono<Integer> updateUserName(@Param("user") User user);

	@Insert(value = "insert into user (user_name, user_phone, user_address, user_city, user_state) "
			+ "values (:user.userName, :user.userPhone, :user.userAddress.userAddress, :user.userAddress.userCity, :user.userAddress.userState)", propertyMapper = {
					@PropertyMapper(javaType = String.class, properties = "user.userPhone, user.userName, user.userAddress.userAddress, user.userAddress.userCity, user.userAddress.userState") }, retrieveId = "user_id", idType = Integer.class)
	public Mono<Integer> insertUser(@Param("user") User user);
}
