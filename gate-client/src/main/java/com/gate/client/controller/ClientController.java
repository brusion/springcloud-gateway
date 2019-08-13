package com.gate.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author brusion
 * @date 2019/8/2
 * @description:
 */
@RestController
public class ClientController {

    @GetMapping("/client")
    public Object index(){
        Map<String,String> map =new HashMap<>();
        map.put("client"," client data");
        return map;
    }
}
