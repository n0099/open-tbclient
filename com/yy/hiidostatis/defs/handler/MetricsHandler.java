package com.yy.hiidostatis.defs.handler;

import android.content.Context;
import com.yy.hiidostatis.api.MetricsWorker;
import com.yy.hiidostatis.defs.controller.HttpSendController;
import com.yy.hiidostatis.inner.AbstractConfig;
import com.yy.hiidostatis.inner.util.SharedTimerTask;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.http.MetricsHttpEncryptUtil;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.pref.HdStatisConfig;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class MetricsHandler {
    public String appkey;
    public long defaultMetricsExpire;
    public Context mContext;
    public HttpSendController metricsSend;
    public Map<String, MetricsWorker> metricsWorkerMap = new ConcurrentHashMap();
    public Map<String, TimeWorker> timers = new ConcurrentHashMap();
    public String ver;

    /* loaded from: classes8.dex */
    public class TimeWorker {
        public long interval;
        public volatile SharedTimerTask timerTask;
        public MetricsWorker worker;

        public TimeWorker(MetricsWorker metricsWorker, long j) {
            this.worker = metricsWorker;
            this.interval = j;
        }

        public synchronized void beginTimer() {
            if (this.timerTask != null) {
                return;
            }
            this.timerTask = new SharedTimerTask() { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.TimeWorker.1
                @Override // java.lang.Runnable
                public void run() {
                    TimeWorker.this.worker.sendNow();
                }
            };
            ThreadPool.getPool().getTimer().schedule(this.timerTask, this.interval * 1000, 1000 * this.interval);
        }

        public synchronized void stopTimer() {
            if (this.timerTask == null) {
                return;
            }
            this.timerTask.cancel();
            this.timerTask = null;
        }
    }

    public MetricsHandler(Context context, String str, String str2, long j) {
        this.mContext = context;
        this.appkey = str;
        this.ver = str2;
        this.defaultMetricsExpire = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MetricsWorker getMetricsWorkerByName(String str) {
        if (str != null && !str.isEmpty()) {
            return this.metricsWorkerMap.get(str);
        }
        return null;
    }

    public boolean containMetric(String str) {
        return this.metricsWorkerMap.containsKey(str);
    }

    public void setVer(String str) {
        this.ver = str;
    }

    private MetricsWorker createMetricsWorker(long j, long j2) {
        return createMetricsWorker(j, j2, this.appkey, this.ver);
    }

    public MetricsWorker addMetricsWorker(String str, long j) {
        if (this.metricsWorkerMap.containsKey(str)) {
            return null;
        }
        return addMetricsWorker(str, this.defaultMetricsExpire, j);
    }

    private MetricsWorker addMetricsWorker(String str, long j, long j2) {
        MetricsWorker createMetricsWorker = createMetricsWorker(j, j2);
        if (createMetricsWorker != null) {
            this.metricsWorkerMap.put(str, createMetricsWorker);
            TimeWorker timeWorker = new TimeWorker(createMetricsWorker, j2);
            timeWorker.beginTimer();
            this.timers.put(str, timeWorker);
        } else {
            L.debug(this, "Create %s MetricsWorker error", str);
        }
        return createMetricsWorker;
    }

    private MetricsWorker createMetricsWorker(long j, long j2, String str, String str2) {
        try {
            AbstractConfig config = HdStatisConfig.getConfig(str);
            File file = new File(this.mContext.getCacheDir().getAbsolutePath() + "/hiido_metrics");
            file.mkdirs();
            if (this.metricsSend == null) {
                this.metricsSend = new HttpSendController(new MetricsHttpEncryptUtil(), file, 20, 2);
            }
            return new MetricsWorker(this.mContext, 10, this.metricsSend, j, str, str2, config.getSdkVer());
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getVer() {
        return this.ver;
    }

    public void onBackground() {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.1
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : MetricsHandler.this.metricsWorkerMap.entrySet()) {
                    ((MetricsWorker) entry.getValue()).sendNow();
                }
            }
        });
    }

    public void onExit() {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.2
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : MetricsHandler.this.timers.entrySet()) {
                    ((TimeWorker) entry.getValue()).stopTimer();
                }
                for (Map.Entry entry2 : MetricsHandler.this.metricsWorkerMap.entrySet()) {
                    ((MetricsWorker) entry2.getValue()).sendNow();
                }
            }
        });
    }

    public void onForeground() {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.3
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : MetricsHandler.this.timers.entrySet()) {
                    ((TimeWorker) entry.getValue()).beginTimer();
                }
            }
        });
    }

    public void reportCount(final String str, final int i, final String str2, final String str3, final long j) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.5
            @Override // java.lang.Runnable
            public void run() {
                MetricsWorker metricsWorkerByName = MetricsHandler.this.getMetricsWorkerByName(str);
                if (metricsWorkerByName != null) {
                    metricsWorkerByName.reportCount(i, str2, str3, j);
                } else {
                    L.debug(this, "NOT Init %s MetricsWork", str);
                }
            }
        });
    }

    public void reportReturnCode(String str, int i, String str2, long j, String str3) {
        reportReturnCode(str, i, str2, j, str3, null);
    }

    public void reportCount(final String str, final int i, final String str2, final String str3, final long j, final int i2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.6
            @Override // java.lang.Runnable
            public void run() {
                MetricsWorker metricsWorkerByName = MetricsHandler.this.getMetricsWorkerByName(str);
                if (metricsWorkerByName != null) {
                    metricsWorkerByName.reportCount(i, str2, str3, j, i2);
                } else {
                    L.debug(this, "NOT Init %s MetricsWork", str);
                }
            }
        });
    }

    public void reportReturnCode(final String str, final int i, final String str2, final long j, final String str3, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.4
            @Override // java.lang.Runnable
            public void run() {
                MetricsWorker metricsWorkerByName = MetricsHandler.this.getMetricsWorkerByName(str);
                if (metricsWorkerByName != null) {
                    metricsWorkerByName.reportReturnCode(i, str2, j, str3, map);
                } else {
                    L.debug(this, "NOT Init %s MetricsWork", str);
                }
            }
        });
    }

    public void reportSrcData(final String str, final int i, final String str2, final String str3, final long j, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.handler.MetricsHandler.7
            @Override // java.lang.Runnable
            public void run() {
                MetricsWorker metricsWorkerByName = MetricsHandler.this.getMetricsWorkerByName(str);
                if (metricsWorkerByName != null) {
                    metricsWorkerByName.reportSrcData(i, str2, str3, j, map);
                } else {
                    L.debug(this, "NOT Init %s MetricsWork", str);
                }
            }
        });
    }
}
