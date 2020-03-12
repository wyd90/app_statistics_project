package com.bawei.flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.List;
import java.util.Map;

public class AppLogInterceptor implements Interceptor {

    public void initialize() {

    }

    public Event intercept(Event event) {
        Map<String, String> headers = event.getHeaders();
        byte[] body = event.getBody();

        String json = new String(body);

        String logType = "";

        //pageLog
        if(json.contains("pageId")){
            logType = "page";
        }
        //eventLog
        if(json.contains("eventId")) {
            logType = "event";
        }

        //usageLog
        if(json.contains("singleUseDurationSecs")) {
            logType = "usage";
        }

        if(json.contains("errorBrief")) {
            logType = "error";
        }

        if(json.contains("network")) {
            logType = "startup";
        }

        headers.put("logType",logType);

        return event;
    }

    public List<Event> intercept(List<Event> events) {
        for(Event event : events) {
            intercept(event);
        }
        return events;
    }

    public void close() {

    }

    public static class Builder implements Interceptor.Builder{

        public Interceptor build() {
            return new AppLogInterceptor();
        }

        public void configure(Context context) {

        }
    }
}

