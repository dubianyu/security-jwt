package com.komlin.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Created by Administrator on 2018/8/30.
 * @author cxw
 */
public class RedisClient {
    private static JedisPool jedisPool;

    public void set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            //返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public static void set(String key, String value,int seconds){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
            jedis.expire(key, seconds);
        } finally {
            //返还到连接池
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public static String get(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            //返还到连接池
            if ( jedis != null ){
                jedis.close();
            }
        }
    }

    public long incr(String key){
        Jedis jedis = null;
        long incr = 0;
        try {
            jedis = jedisPool.getResource();
            jedis.incr(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //返还到连接池
            if ( jedis != null ){
                jedis.close();
            }
        }
        return incr;
    }
    public static Set<String> keys(String key){
        Jedis jedis = null;
        Set<String> set;
        try {
            jedis = jedisPool.getResource();
            set = jedis.keys(key);
        } finally {
            //返还到连接池
            if ( jedis != null ){
                jedis.close();
            }
        }
        return set;
    }

    public static void expire(String key, int seconds){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.expire(key, seconds);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public long del(String key){
        Jedis jedis = null;
        long result = 0L;
        try {
            jedis = jedisPool.getResource();
            result = jedis.del(key);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
        return result;
    }


    public String rename(String oldKey,String newKey){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.rename(oldKey,newKey);
        } finally {
            //返还到连接池
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

}
