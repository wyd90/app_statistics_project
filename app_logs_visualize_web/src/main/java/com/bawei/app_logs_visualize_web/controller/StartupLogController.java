package com.bawei.app_logs_visualize_web.controller;

import com.bawei.app_logs_visualize_web.service.StartupLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartupLogController {

    @Autowired
    private StartupLogService startupLogService;

    @GetMapping("/getUserCount/{appId}")
    public Long getUserCountByAppId(@PathVariable("appId")String appId){
        return startupLogService.getUserCount(appId);
    }

}
