package com.bawei.common;

public class AppLogEntity {
    private AppErrorLog[] appErrorLogs;
    private AppPageLog[] appPageLogs;
    private AppStartupLog[] appStartupLogs;
    private AppUsageLog[] appUsageLogs;
    private AppEventLog[] appEventLogs;

    public AppErrorLog[] getAppErrorLogs() {
        return appErrorLogs;
    }

    public void setAppErrorLogs(AppErrorLog[] appErrorLogs) {
        this.appErrorLogs = appErrorLogs;
    }

    public AppPageLog[] getAppPageLogs() {
        return appPageLogs;
    }

    public void setAppPageLogs(AppPageLog[] appPageLogs) {
        this.appPageLogs = appPageLogs;
    }

    public AppStartupLog[] getAppStartupLogs() {
        return appStartupLogs;
    }

    public void setAppStartupLogs(AppStartupLog[] appStartupLogs) {
        this.appStartupLogs = appStartupLogs;
    }

    public AppUsageLog[] getAppUsageLogs() {
        return appUsageLogs;
    }

    public void setAppUsageLogs(AppUsageLog[] appUsageLogs) {
        this.appUsageLogs = appUsageLogs;
    }

    public AppEventLog[] getAppEventLogs() {
        return appEventLogs;
    }

    public void setAppEventLogs(AppEventLog[] appEventLogs) {
        this.appEventLogs = appEventLogs;
    }
}
