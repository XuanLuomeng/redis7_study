package com.gduf.redis7_study.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.List;

/**
 * @author LuoXuanwei
 * @date 2023/8/11 0:13
 */
public class LettuceDemo {
    public static void main(String[] args) {
        //1 使用构建器链式编程来builder我们redisURI
        RedisURI uri = RedisURI.Builder
                .redis("192.168.190.100")
                .withPort(6379)
                .withAuthentication("default", "111111")
                .build();

        //2 创建连接客户端
        RedisClient redisClient = RedisClient.create(uri);
        StatefulRedisConnection connect = redisClient.connect();

        //3 通过conn创建操作的command
        RedisCommands commands = connect.sync();

        //===============biz===============
        //keys
        List keys = commands.keys("*");
        System.out.println(keys);

        //string
        commands.set("k5","hello-lettuce");
        System.out.println(commands.get("k5"));

        //......

        //===============biz===============

        //4 关闭各种释放资源
        connect.close();
        redisClient.shutdown();
    }
}
