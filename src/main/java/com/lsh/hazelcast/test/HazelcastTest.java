package com.lsh.hazelcast.test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.rules.Stopwatch;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LiuShihao
 * @Date: 2022/8/22 18:06
 * @Desc:
 */
@Slf4j
public class HazelcastTest {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        //集群组名称
//        clientConfig.getGroupConfig().setName("dev");
        //节点地址
        clientConfig.getNetworkConfig().addAddress("192.168.153.129");
        //客户端
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        //map缓存
        IMap<Object, Object> cache = client.getMap("my-distributed-map");
        Set<Map.Entry<Object, Object>> entries = cache.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        //并发测试
//        Runnable runnable = () -> {
//            long total = 10000;
//            Stopwatch stopwatch = Stopwatch.createStarted();
//            for (int i = 0; i < total; i++) {
//                //插入缓存
//                userInfoMap.put(i, userInfo);
//            }
//            stopwatch.stop();
//
//            log.info("total:{},elapsed:{},qps:{}", total, stopwatch.elapsed(TimeUnit.MILLISECONDS), stopwatch.elapsed(TimeUnit.MILLISECONDS) / total);
//        };

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        int threadNum = 10;
//        for (int i = 0; i < threadNum; i++) {
//            executorService.submit(runnable);
//        }
    }
}