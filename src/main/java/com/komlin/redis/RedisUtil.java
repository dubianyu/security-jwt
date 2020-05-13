package com.komlin.redis;


import com.komlin.util.SpringUtils;

import java.util.Set;

/**
 * Created by Administrator on 2018/8/30.
 */
public class RedisUtil {

    private static RedisService redisService = SpringUtils.getBean(RedisService.class);

    public static void set(String key, String value){
        redisService.set(key,value);
    }

    public static void set(String key, String value,int seconds){
        redisService.set(key,value,seconds);
    }

    public static long del(String key){
        return redisService.del(key);
    }

    public static String get(String key){
        return redisService.get(key);
    }

    public static void expire(String key, int seconds){
        redisService.expire(key,seconds);
    }

    public static String rename(String oldKey,String newKey){
        return redisService.rename(oldKey,newKey);
    }

    public static Set<String> keys(String key){
        return redisService.keys(key);
    }

    public static long incr(String key){
        return redisService.incr(key);
    }
}
