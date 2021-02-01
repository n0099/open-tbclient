package com.kwai.player.qos;

import com.kwai.video.player.IMediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AppQosLiveRealtime {
    private static final String TAG = "AppQosLiveRealtime";
    private static final boolean VERBOSE = false;
    private MetricMonitor mMetricMonitor;
    private long mMoniterintervalMs;
    IMediaPlayer.OnQosStatListener mOnQosStatListener;
    private Object mQosObject;
    private AppLiveReatimeInfoProvider mRealtimeInfoProvider;
    private final long mReportIntervalMs;
    private Timer timer;
    private TimerTask timerTask;
    private long lastSampleTime = 0;
    private long lastLiveRecordTime = 0;
    private long mTickStartTime = 0;
    private boolean mStarted = false;
    private volatile boolean mIsFirstQosStatReport = true;
    private volatile boolean mIsLastQosStatReport = false;

    public AppQosLiveRealtime(long j, long j2, AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, Object obj) {
        this.mMoniterintervalMs = j;
        this.mReportIntervalMs = j2;
        this.mRealtimeInfoProvider = appLiveReatimeInfoProvider;
        this.mQosObject = obj;
        this.mMetricMonitor = new MetricMonitor(appLiveReatimeInfoProvider);
    }

    public JSONObject getQosStatistics(long j) {
        JSONObject jSONObject;
        synchronized (this.mQosObject) {
            int i = this.mIsFirstQosStatReport ? 1 : 0;
            int i2 = this.mIsLastQosStatReport ? 1 : 0;
            if (this.mIsFirstQosStatReport) {
                this.mIsFirstQosStatReport = false;
            }
            String liveRealTimeQosJson = this.mRealtimeInfoProvider.getLiveRealTimeQosJson(i, i2, this.mTickStartTime, j, this.mReportIntervalMs);
            if (liveRealTimeQosJson != null) {
                try {
                    jSONObject = new JSONObject(liveRealTimeQosJson);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject = null;
        }
        return jSONObject;
    }

    public void startReport(IMediaPlayer.OnQosStatListener onQosStatListener) {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mOnQosStatListener = onQosStatListener;
        this.mTickStartTime = System.currentTimeMillis();
        this.timer = new Timer();
        this.timerTask = new TimerTask() { // from class: com.kwai.player.qos.AppQosLiveRealtime.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                AppQosLiveRealtime.this.lastSampleTime = currentTimeMillis;
                AppQosLiveRealtime.this.mMetricMonitor.sample(currentTimeMillis - AppQosLiveRealtime.this.lastSampleTime);
                long j = currentTimeMillis - AppQosLiveRealtime.this.lastLiveRecordTime;
                if (j >= AppQosLiveRealtime.this.mReportIntervalMs) {
                    AppQosLiveRealtime.this.uploadReport(j);
                    AppQosLiveRealtime.this.lastLiveRecordTime = currentTimeMillis;
                    AppQosLiveRealtime.this.mMetricMonitor.clear();
                }
            }
        };
        this.timer.schedule(this.timerTask, this.mMoniterintervalMs, this.mMoniterintervalMs);
        this.lastSampleTime = System.currentTimeMillis();
        this.lastLiveRecordTime = this.lastSampleTime;
    }

    public void stopReport() {
        if (this.mStarted) {
            this.mStarted = false;
            if (this.timerTask != null) {
                this.timerTask.cancel();
                this.timerTask = null;
            }
            if (this.timer != null) {
                this.timer.cancel();
                this.timer = null;
            }
            this.mIsLastQosStatReport = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.lastSampleTime = currentTimeMillis;
            this.mMetricMonitor.sample(currentTimeMillis - this.lastSampleTime);
            uploadReport(currentTimeMillis - this.lastLiveRecordTime);
            this.lastLiveRecordTime = currentTimeMillis;
            this.mMetricMonitor.clear();
        }
    }

    public void uploadReport(long j) {
        if (this.mRealtimeInfoProvider.isMediaPlayerValid()) {
            JSONObject qosStatistics = getQosStatistics(j);
            if (this.mOnQosStatListener != null && qosStatistics != null) {
                this.mOnQosStatListener.onQosStat(this.mRealtimeInfoProvider, qosStatistics);
            }
            this.mTickStartTime = System.currentTimeMillis();
        }
    }
}
