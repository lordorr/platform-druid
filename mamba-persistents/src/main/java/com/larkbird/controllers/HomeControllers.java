package com.larkbird.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lordorr on 2017/3/17.
 */

public class HomeControllers {
    //@RequestMapping("/")
    public String Hello() {
        System.out.print("--------");
        return "hello index";
    }
}
