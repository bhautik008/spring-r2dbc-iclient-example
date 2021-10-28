package example.spring.r2dbc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.spring.r2dbc.domain.User;
import example.spring.r2dbc.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class R2DBCController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/allmap")
	public Flux<Map<String, Object>> getAllMap() {
		return userRepo.getAllMap();
	}
	
	@GetMapping("/all")
	public Flux<User> getAllUser() {
		return userRepo.getAll();
	}

	@GetMapping("/id/{userId}")
	public Mono<User> getUserById(@PathVariable("userId") Integer userId) {
		return userRepo.getUserById(userId);
	}

	@PutMapping("/updatename")
	public Mono<Integer> updateUserName(@RequestBody User user) {
		return userRepo.updateUserName(user);
	}

	@PostMapping("/insert")
	public Mono<Integer> insertUser(@RequestBody User user) {
		return userRepo.insertUser(user);
	}
}
