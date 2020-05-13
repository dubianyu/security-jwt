package com.komlin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.komlin.mapper")
public class YimayunV2Application {

    public static void main(String[] args) {
        SpringApplication.run(YimayunV2Application.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ 启动成功 ლ(´ڡ`ლ)ﾞ\n" +
                "  _  __               _ _       \n" +
                " | |/ /              | (_)      \n" +
                " | ' / ___  _ __ ___ | |_ _ __  \n" +
                " |  < / _ \\| '_ ` _ \\| | | '_ \\ \n" +
                " | . \\ (_) | | | | | | | | | | |\n" +
                " |_|\\_\\___/|_| |_| |_|_|_|_| |_|\n" );
    }

}
