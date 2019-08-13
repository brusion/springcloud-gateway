package com.gate.filter.controller;

import com.gate.filter.jwt.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brusion
 * @date 2019/8/2
 * @description: token生成与校验接口
 */
@RestController
public class TokenController {

    /**
     * 创建token
     */
    @GetMapping("/token")
    public String get(@RequestParam String phone, @RequestParam String userId, @RequestParam String companyId, @RequestParam String companyName) {
        return JwtUtil.generateToken(phone, userId, companyId, companyName);
    }

    /**
     * token解析
     */
    @GetMapping("/data")
    public Object getTokenData(@RequestParam String token) {
        return JwtUtil.validateToken(token);
    }

}
