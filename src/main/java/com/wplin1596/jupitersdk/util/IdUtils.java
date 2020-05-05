package com.wplin1596.jupitersdk.util;

import java.util.UUID;

/**
 * @Description TODO
 * @ClassName IdUtils
 * @Author wplin1596
 * @Date 2020/4/30 22:20
 * @Version 1.0.0
 */
public class IdUtils {
    public static String id() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
