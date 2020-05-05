package com.wplin1596.jupitersdk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description 项目默认欢迎页控制类
 * @ClassName IndexController
 * @Author wplin1596
 * @Date 2020/4/30 10:44
 * @Version 1.0.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "add";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }
}
