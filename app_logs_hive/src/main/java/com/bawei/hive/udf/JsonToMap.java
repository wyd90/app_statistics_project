package com.bawei.hive.udf;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.Map;

public class JsonToMap extends UDF {
    public Map<String,String> evaluate(String json,String param){
        JSONObject jsonObject = JSONObject.parseObject(json);
        Map<String,String> res = (Map<String,String>)jsonObject.get("paramKeyValueMap");
        return res;
    }
}
