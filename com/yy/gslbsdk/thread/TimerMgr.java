package com.yy.gslbsdk.thread;

import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import java.util.Timer;
/* loaded from: classes7.dex */
public class TimerMgr {
    public static final String TAG = "TimerMgr";
    public static TimerMgr mTimerMgr;
    public HashMap<String, TimerTaskInfo> workerList = new HashMap<>();
    public Timer mTimer = new Timer("Timer-gslb");

    public static TimerMgr getInstance() {
        if (mTimerMgr == null) {
            mTimerMgr = new TimerMgr();
        }
        return mTimerMgr;
    }

    public int addWorker(TimerTaskInfo timerTaskInfo, long j, long j2) {
        if (timerTaskInfo == null || j2 <= 0) {
            return 5;
        }
        if (this.workerList.containsKey(timerTaskInfo.getTaskName())) {
            return 0;
        }
        try {
            this.mTimer.schedule(timerTaskInfo.getWorker(), j, j2);
            this.workerList.put(timerTaskInfo.getTaskName(), timerTaskInfo);
        } catch (Exception e2) {
            LogTools.printWarning(TAG, e2);
        }
        return 0;
    }

    public int stopAllWorker() {
        this.mTimer.cancel();
        this.workerList.clear();
        return 0;
    }
}
