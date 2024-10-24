package com.redis.entity;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("empHash")
public class RedisEntity 
{
		
		private Integer id;
        private String ename;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		@Override
		public String toString() {
			return "RedisEntity [id=" + id + ", ename=" + ename + "]";
		}
        
}
