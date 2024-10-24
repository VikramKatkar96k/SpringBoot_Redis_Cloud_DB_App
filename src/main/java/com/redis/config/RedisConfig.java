package com.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfig {

	@Value("${spring.data.redis.username}")
	private String uname;
	
	@Value("${spring.data.redis.password}")
	private String pwd;
	
	@Value("${spring.data.redis.port}")
	private Integer port;
	
	@Value("${spring.data.redis.url}")
	private String url;

	public RedisConfig() {
		System.out.println("Config Class");
	}

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(url, port);
		configuration.setUsername(uname);
		configuration.setPassword(pwd);

		JedisClientConfiguration build = JedisClientConfiguration.builder().build();

		return new JedisConnectionFactory(configuration, build);
	}
}
