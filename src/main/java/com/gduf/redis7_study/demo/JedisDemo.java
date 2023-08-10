package com.gduf.redis7_study.demo;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author LuoXuanwei
 * @date 2023/8/10 23:47
 */
public class JedisDemo {
    public static void main(String[] args) {
        //1 connection获得，通过指定ip和端口号
        Jedis jedis = new Jedis("192.168.190.100", 6379);

        //2 指定访问服务器的密码
        jedis.auth("111111");

        //3 获得了jedis客户端，可以像jdbc一样，访问我们的redis
        System.out.println(jedis.ping());

        //key
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        //string
        jedis.set("k3", "hello-Jedis");
        System.out.println(jedis.get("k3"));
        System.out.println(jedis.ttl("k3"));
        jedis.expire("k3", 20L);

        //list
        jedis.lpush("list", "11", "12", "13");
        List<String> list = jedis.lrange("list", 0, 1);
        for (String element : list) {
            System.out.println(element);
        }
    }
}
