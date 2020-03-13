package com.bawei.app_logs_visualize_web.service;

import com.bawei.app_logs_visualize_web.dao.StartupLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StartupLogService {

    @Autowired
    private StartupLogMapper startupLogMapper;


    public Long getUserCount(String appId) {
        return startupLogMapper.getUserCount(appId);
    }
}
