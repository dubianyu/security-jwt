package com.komlin.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Administrator on 2018/8/30.
 */
@Service("redisService")
public class RedisService {

    @Autowired
    private RedisClient redisClient;

    public void set(String key, String value) {
        redisClient.set(key, value);
    }

    public void set(String key, String value, int seconds) {
        redisClient.set(key, value, seconds);
    }

    public long del(String key) {
        return redisClient.del(key);
    }

    public String get(String key) {
        return redisClient.get(key);
    }

    public void expire(String key, int seconds) {
        redisClient.expire(key, seconds);
    }

    public String rename(String oldKey, String newKey) {
        return redisClient.rename(oldKey, newKey);
    }

    public Set<String> keys(String key) {
        return redisClient.keys(key);
    }

    public long incr(String key) {
        return redisClient.incr(key);
    }
}
