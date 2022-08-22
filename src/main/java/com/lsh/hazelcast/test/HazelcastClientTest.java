package com.lsh.hazelcast.test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.spi.properties.ClientProperty;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.junit.Test;

import java.util.Random;

/**
 * @Author: LiuShihao
 * @Date: 2022/8/22 21:32
 * @Desc:
 */

public class HazelcastClientTest {

    public static String YOUR_CLUSTER_NAME = "dev";
    public static String YOUR_CLUSTER_PASSWORD = "";

    @Test
    public  void test() throws InterruptedException {
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress("192.168.153.129");
        config.setGroupConfig(new GroupConfig(YOUR_CLUSTER_NAME));
        config.setProperty("hazelcast.client.statistics.enabled","true");
//        config.setProperty(ClientProperty.HAZELCAST_CLOUD_DISCOVERY_TOKEN.getName(), "YOUR_CLUSTER_DISCOVERY_TOKEN");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
        IMap<String, String> map = client.getMap("map");
        map.put("key", "value");
        if (map.get("key").equals("value")) {
            System.out.println("Connection Successful!");
            System.out.println("Now, `map` will be filled with random entries.");
        } else {
            throw new RuntimeException("Connection failed, check your configuration.");
        }
        Random random = new Random();
        while (true) {
            int randomKey = (int) random.nextInt(100_000);
            map.put("key" + randomKey, "value" + randomKey);
            map.get("key" + random.nextInt(100_000));
            if(randomKey % 10 == 0 ) {
                System.out.println("map size:" + map.size());
            }
            Thread.sleep(100);
        }
    }
}
