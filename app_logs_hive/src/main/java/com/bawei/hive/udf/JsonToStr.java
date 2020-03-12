package com.bawei.hive.udf;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.hive.ql.exec.UDF;

public class JsonToStr extends UDF {

    public String evaluate(String json,String fieldName) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        return jsonObject.getString(fieldName);
    }
}
