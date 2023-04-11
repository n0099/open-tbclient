package com.yy.gslbsdk.statistic;

import android.text.TextUtils;
import com.yy.gslbsdk.thread.ThreadInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class StatisticMgr {
    public static StatisticMgr sInstance;
    public IGslbStatistic mStatistic = null;
    public ScheduledThreadPoolExecutor mExecutor = new ScheduledThreadPoolExecutor(1);
    public Map<String, StatisticInfo> mMapStatistic = new ConcurrentHashMap();

    /* loaded from: classes9.dex */
    public interface IGslbStatistic {
        void onStatistic(Map<String, String> map);
    }

    public static StatisticMgr getInstance() {
        if (sInstance == null) {
            sInstance = new StatisticMgr();
        }
        return sInstance;
    }

    public Map<String, StatisticInfo> getMapStatistic() {
        if (this.mMapStatistic == null) {
            this.mMapStatistic = new ConcurrentHashMap();
        }
        return this.mMapStatistic;
    }

    public IGslbStatistic getStatistic() {
        return this.mStatistic;
    }

    public void addTask(ThreadInfo threadInfo) {
        this.mExecutor.execute(threadInfo);
    }

    public StatisticInfo getStatisticInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return new StatisticInfo();
        }
        StatisticInfo statisticInfo = getMapStatistic().get(str);
        if (statisticInfo == null) {
            return new StatisticInfo();
        }
        return statisticInfo;
    }

    public void onStatistic(Map<String, String> map) {
        IGslbStatistic iGslbStatistic = this.mStatistic;
        if (iGslbStatistic == null) {
            return;
        }
        iGslbStatistic.onStatistic(map);
    }

    public void removeStatisticInfo(String str) {
        getMapStatistic().remove(str);
    }

    public void setStatistic(IGslbStatistic iGslbStatistic) {
        this.mStatistic = iGslbStatistic;
    }

    public void addTask(ThreadInfo threadInfo, long j) {
        this.mExecutor.schedule(threadInfo, j, TimeUnit.MILLISECONDS);
    }

    public boolean setStatisticInfo(String str, StatisticInfo statisticInfo) {
        if (TextUtils.isEmpty(str) || getMapStatistic().containsKey(str)) {
            return false;
        }
        getMapStatistic().put(str, statisticInfo);
        return true;
    }
}
