package com.example.demoDataAcess;

import com.example.demoDataAcess.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoDataAcessApplicationTests {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	UserServiceImpl userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRedis() {
		stringRedisTemplate.opsForValue().set("123","456");
	}

	@Transactional
	@Test
	public  void testCache(){
		Person p = userService.getOne(1);
		System.out.println(p.getId());
	}
}
