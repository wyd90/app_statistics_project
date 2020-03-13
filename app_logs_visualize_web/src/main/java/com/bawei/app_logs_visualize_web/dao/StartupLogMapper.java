package com.bawei.app_logs_visualize_web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface StartupLogMapper {

    @Select("select count(distinct(deviceid)) from startup_logs where appid = #{appId}")
    Long getUserCount(@Param("appId")String appId);
}
