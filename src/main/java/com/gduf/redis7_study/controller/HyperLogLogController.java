package com.gduf.redis7_study.controller;

import com.gduf.redis7_study.service.HyperLogLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LuoXuanwei
 * @date 2023/8/15 23:50
 */
@Api(tags = "淘宝亿级UV的Redis统计方案")
@RestController
@Slf4j
public class HyperLogLogController {
    @Resource
    HyperLogLogService hyperLogLogService;

    @ApiOperation("获得IP去重复后的UV统计访问量")
    @GetMapping("/uv")
    public long uv() {
        return hyperLogLogService.uv();
    }
}
