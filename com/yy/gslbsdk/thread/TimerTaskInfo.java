package com.yy.gslbsdk.thread;

import java.util.TimerTask;
/* loaded from: classes8.dex */
public class TimerTaskInfo {
    public String taskName;
    public TimerTask worker;

    public String getTaskName() {
        return this.taskName;
    }

    public TimerTask getWorker() {
        return this.worker;
    }

    public void setTaskName(String str) {
        this.taskName = str;
    }

    public void setWorker(TimerTask timerTask) {
        this.worker = timerTask;
    }
}
