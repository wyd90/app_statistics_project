package com.bawei.common;

/**
 * 应用上报的app错误日志相关信息
 */
public class AppErrorLog extends AppBaseLog {

    private String errorBrief;    //错误摘要
    private String errorDetail;       //错误详情

    public String getErrorBrief() {
        return errorBrief;
    }

    public void setErrorBrief(String errorBrief) {
        this.errorBrief = errorBrief;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}
