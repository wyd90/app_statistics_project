package com.bawei.hive.udf;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.hive.ql.exec.UDF;

public class JsonToLong extends UDF {
    public Long evaluate(String json,String field) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        return jsonObject.getLong(field);
    }
}
