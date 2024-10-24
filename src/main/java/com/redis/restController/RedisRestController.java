		package com.redis.restController;
		
		import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.RedisEntity;
import com.redis.respo.redisRespo;
		
		@RestController
		public class RedisRestController {
			@Autowired
			private redisRespo respo;
		
			public RedisRestController() {
				System.out.println("Redis RestController Call..");
			}
		
			@PostMapping("/employee")
			public ResponseEntity<String> addEmployee(@RequestBody RedisEntity entity) {
				RedisEntity save = respo.save(entity);
				String info = "record inserted id " + entity.getId() + " name " + entity.getEname();
				return new ResponseEntity<>(info, HttpStatus.OK);
			}
		
			@GetMapping("/employees")
			public Iterable<RedisEntity> recordEmployee() {
				return respo.findAll();
			}
		
			@DeleteMapping("/del/{id}")
			public void delEmployee(@PathVariable("id") Integer id) {
				System.out.println(id);
				 respo.deleteById(id);
			}
			
		}
