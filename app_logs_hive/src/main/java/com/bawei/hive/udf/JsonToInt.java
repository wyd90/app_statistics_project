package com.bawei.hive.udf;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.hive.ql.exec.UDF;

public class JsonToInt extends UDF {
    public Integer evaluate(String json,String field) {
        return JSONObject.parseObject(json).getInteger(field);
    }
}
