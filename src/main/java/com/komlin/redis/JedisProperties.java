package com.komlin.redis;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2018/8/30.
 */

@ConfigurationProperties(prefix = JedisProperties.JEDIS_PREFIX)
public class JedisProperties {
    public static final String JEDIS_PREFIX = "jedis";

    private String host;

    private String password;

    private int port;

    private int maxTotal;

    private int maxIdle;

    private int maxWaitMillis;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }
}
