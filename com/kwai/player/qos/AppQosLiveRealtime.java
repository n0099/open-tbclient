package com.kwai.player.qos;

import com.kwai.video.player.IMediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AppQosLiveRealtime {
    public static final String TAG = "AppQosLiveRealtime";
    public static final boolean VERBOSE = false;
    public MetricMonitor mMetricMonitor;
    public long mMoniterintervalMs;
    public IMediaPlayer.OnQosStatListener mOnQosStatListener;
    public Object mQosObject;
    public AppLiveReatimeInfoProvider mRealtimeInfoProvider;
    public final long mReportIntervalMs;
    public Timer timer;
    public TimerTask timerTask;
    public long lastSampleTime = 0;
    public long lastLiveRecordTime = 0;
    public long mTickStartTime = 0;
    public boolean mStarted = false;
    public volatile boolean mIsFirstQosStatReport = true;
    public volatile boolean mIsLastQosStatReport = false;

    public AppQosLiveRealtime(long j, long j2, AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, Object obj) {
        this.mMoniterintervalMs = j;
        this.mReportIntervalMs = j2;
        this.mRealtimeInfoProvider = appLiveReatimeInfoProvider;
        this.mQosObject = obj;
        this.mMetricMonitor = new MetricMonitor(appLiveReatimeInfoProvider);
    }

    public JSONObject getQosStatistics(long j) {
        synchronized (this.mQosObject) {
            int i = this.mIsFirstQosStatReport ? 1 : 0;
            int i2 = this.mIsLastQosStatReport ? 1 : 0;
            if (this.mIsFirstQosStatReport) {
                this.mIsFirstQosStatReport = false;
            }
            String liveRealTimeQosJson = this.mRealtimeInfoProvider.getLiveRealTimeQosJson(i, i2, this.mTickStartTime, j, this.mReportIntervalMs);
            if (liveRealTimeQosJson != null) {
                try {
                    return new JSONObject(liveRealTimeQosJson);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
    }

    public void startReport(IMediaPlayer.OnQosStatListener onQosStatListener) {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mOnQosStatListener = onQosStatListener;
        this.mTickStartTime = System.currentTimeMillis();
        this.timer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.kwai.player.qos.AppQosLiveRealtime.1
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
        this.timerTask = timerTask;
        Timer timer = this.timer;
        long j = this.mMoniterintervalMs;
        timer.schedule(timerTask, j, j);
        long currentTimeMillis = System.currentTimeMillis();
        this.lastSampleTime = currentTimeMillis;
        this.lastLiveRecordTime = currentTimeMillis;
    }

    public void stopReport() {
        if (this.mStarted) {
            this.mStarted = false;
            TimerTask timerTask = this.timerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.timerTask = null;
            }
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
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
            IMediaPlayer.OnQosStatListener onQosStatListener = this.mOnQosStatListener;
            if (onQosStatListener != null && qosStatistics != null) {
                onQosStatListener.onQosStat(this.mRealtimeInfoProvider, qosStatistics);
            }
            this.mTickStartTime = System.currentTimeMillis();
        }
    }
}
