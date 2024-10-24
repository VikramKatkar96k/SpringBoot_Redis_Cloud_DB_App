package com.redis.respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis.entity.RedisEntity;

public interface redisRespo extends JpaRepository<RedisEntity, Integer>
{

}
