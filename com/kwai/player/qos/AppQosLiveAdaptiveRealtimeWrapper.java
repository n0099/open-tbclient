package com.kwai.player.qos;

import com.kwai.video.player.IMediaPlayer;
/* loaded from: classes6.dex */
public class AppQosLiveAdaptiveRealtimeWrapper {
    public static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION_SEC = 2;
    public static final int DEFAULT_MONITOR_INTERVAL = 1000;
    public final AppLiveReatimeInfoProvider mAppLiveReatimeInfoProvider;
    public AppQosLiveAdaptiveRealtime mAppQosLiveAdaptiveRealtime;
    public final boolean mEnable;
    public boolean mEnableAdditinalQosFlag;
    public Object mLiveAdaptiveQosObject = new Object();
    public long mLiveAdaptiveQosTickDuration = 2000;
    public IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener;
    public long mStartTsMs;

    public AppQosLiveAdaptiveRealtimeWrapper(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, boolean z) {
        this.mAppLiveReatimeInfoProvider = appLiveReatimeInfoProvider;
        this.mEnable = z;
    }

    private synchronized void startLiveAdaptiveQosStatTimer() {
        if (this.mAppQosLiveAdaptiveRealtime != null) {
            return;
        }
        AppQosLiveAdaptiveRealtime appQosLiveAdaptiveRealtime = new AppQosLiveAdaptiveRealtime(1000L, this.mLiveAdaptiveQosTickDuration, this.mAppLiveReatimeInfoProvider, this.mLiveAdaptiveQosObject);
        this.mAppQosLiveAdaptiveRealtime = appQosLiveAdaptiveRealtime;
        appQosLiveAdaptiveRealtime.setPlayStartTime(this.mStartTsMs);
        this.mAppQosLiveAdaptiveRealtime.setEnableLiveAdaptiveAdditionalQosStat(this.mEnableAdditinalQosFlag);
        this.mAppQosLiveAdaptiveRealtime.startReport(this.mOnLiveAdaptiveQosStatListener);
    }

    private synchronized void stopLiveAdaptiveQosStatTimer() {
        if (this.mAppQosLiveAdaptiveRealtime == null) {
            return;
        }
        this.mAppQosLiveAdaptiveRealtime.stopReport();
        this.mAppQosLiveAdaptiveRealtime = null;
    }

    public void setEnableLiveAdaptiveAdditionalQosStat(boolean z) {
        this.mEnableAdditinalQosFlag = z;
    }

    public void setOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        this.mOnLiveAdaptiveQosStatListener = onLiveAdaptiveQosStatListener;
    }

    public void setTickDurationMs(long j) {
        if (j <= 0) {
            return;
        }
        this.mLiveAdaptiveQosTickDuration = j;
    }

    public void start() {
        if (this.mEnable) {
            this.mStartTsMs = System.currentTimeMillis();
            startLiveAdaptiveQosStatTimer();
        }
    }

    public void stop() {
        if (this.mEnable) {
            stopLiveAdaptiveQosStatTimer();
        }
    }
}
