package com.komlin.pojo.auth;

import lombok.Builder;
import lombok.Data;

/**
 * @author : JoeTao
 * createAt: 2018/9/17
 */
@Data
@Builder
public class Role {
    private Long id;
    private String name;
}
