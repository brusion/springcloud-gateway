package com.gate.service.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author brusion
 * @date 2019/8/2
 * @description:
 */
@Component
@FeignClient(value = "provider-client")
public interface ClientFeign {

    @GetMapping("/client")
    public Object index();
}
