package com.lsh.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @Author: LiuShihao
 * @Date: 2022/8/22 23:16
 * @Desc:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HazelcastTest {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    public String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) ;


    @Test
    public void test1(){
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("hazelcastMap");
        hazelcastMap.put("test", now);
        System.out.println(hazelcastMap.get("test"));
    }
}
