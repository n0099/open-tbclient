package com.yy.gslbsdk.thread;

import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import java.util.Timer;
/* loaded from: classes8.dex */
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

    public int stopAllWorker() {
        this.mTimer.cancel();
        this.workerList.clear();
        return 0;
    }

    public int addWorker(TimerTaskInfo timerTaskInfo, long j, long j2) {
        if (timerTaskInfo != null && j2 > 0) {
            if (this.workerList.containsKey(timerTaskInfo.getTaskName())) {
                return 0;
            }
            try {
                this.mTimer.schedule(timerTaskInfo.getWorker(), j, j2);
                this.workerList.put(timerTaskInfo.getTaskName(), timerTaskInfo);
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return 0;
        }
        return 5;
    }
}
