package com.bawei.hive.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection conn = DriverManager.getConnection("jdbc:hive2://node4:10000", "root", "");

        Statement stat = conn.createStatement();

        stat.execute("use applogs");
        String year = args[0];
        String month = args[1];
        String day = args[2];
        String hour = args[3];
        String minute = args[4];

        //导入数据
        stat.execute("load data inpath '/applogs/startup/"+year+"-"+month+"-"+day+"/"+hour+"/"+minute+"' into table startup_logs_json partition(ym='"+year+month+"',day='"+day+"',hm='"+hour+minute+"')");
        stat.execute("load data inpath '/applogs/error/"+year+"-"+month+"-"+day+"/"+hour+"/"+minute+"' into table error_logs_json partition(ym='"+year+month+"',day='"+day+"',hm='"+hour+minute+"')");
        stat.execute("load data inpath '/applogs/usage/"+year+"-"+month+"-"+day+"/"+hour+"/"+minute+"' into table usage_logs_json partition(ym='"+year+month+"',day='"+day+"',hm='"+hour+minute+"')");
        stat.execute("load data inpath '/applogs/event/"+year+"-"+month+"-"+day+"/"+hour+"/"+minute+"' into table event_logs_json partition(ym='"+year+month+"',day='"+day+"',hm='"+hour+minute+"')");
        stat.execute("load data inpath '/applogs/page/"+year+"-"+month+"-"+day+"/"+hour+"/"+minute+"' into table page_logs_json partition(ym='"+year+month+"',day='"+day+"',hm='"+hour+minute+"')");


        //注册临时函数
        stat.execute("add jar hdfs://node4:8020/hiveudf/app_logs_hive-1.0-SNAPSHOT.jar");
        stat.execute("create temporary function jsontostr as 'com.bawei.hive.udf.JsonToStr'");
        stat.execute("create temporary function jsontolong as 'com.bawei.hive.udf.JsonToLong'");
        stat.execute("create temporary function jsontoint as 'com.bawei.hive.udf.JsonToInt'");

        //转换数据
        stat.execute("insert into startup_logs partition(ym='"+year+month+"',day='"+day+"',hm='"+hour+minute+"') select jsontolong(json,'createdAtMs'),jsontostr(json,'appId'),jsontostr(json,'tenantId'),jsontostr(json,'deviceId'),jsontostr(json,'appVersion'),jsontostr(json,'appChannel'),jsontostr(json,'appPlatform'),jsontostr(json,'osType'),jsontostr(json,'deviceStyle'),jsontostr(json,'country'),jsontostr(json,'province'),jsontostr(json,'ipAddress'),jsontostr(json,'network'),jsontostr(json,'carrier'),jsontostr(json,'brand'),jsontostr(json,'screenSize') from startup_logs_json where ym='"+year+month+"' and day='"+day+"' and hm='"+hour+minute+"'");

    }
}
