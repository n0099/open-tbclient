package com.kwai.player.qos;

import com.kwai.video.player.IMediaPlayer;
/* loaded from: classes3.dex */
public class AppQosLiveRealtimeWrapper {
    private static final int DEFAULT_MONITOR_INTERVAL = 1000;
    private static final int DEFAULT_QOS_TICK_DURATION_SEC = 10;
    private AppQosLiveRealtime mAppQosLiveRealtime;
    private final boolean mEnable;
    private IMediaPlayer.OnQosStatListener mOnQosStatListener;
    private final AppLiveReatimeInfoProvider mProvider;
    private long mTickDurMs = 10000;

    public AppQosLiveRealtimeWrapper(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, boolean z) {
        this.mProvider = appLiveReatimeInfoProvider;
        this.mEnable = z;
    }

    private synchronized void startQosStatTimer() {
        if (this.mAppQosLiveRealtime == null) {
            this.mAppQosLiveRealtime = new AppQosLiveRealtime(1000L, this.mTickDurMs, this.mProvider, new Object());
            this.mAppQosLiveRealtime.startReport(this.mOnQosStatListener);
        }
    }

    private synchronized void stopQosStatTimer() {
        if (this.mAppQosLiveRealtime != null) {
            this.mAppQosLiveRealtime.stopReport();
            this.mAppQosLiveRealtime = null;
        }
    }

    public void setOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        this.mOnQosStatListener = onQosStatListener;
    }

    public void setTickDurationMs(long j) {
        if (j <= 0) {
            return;
        }
        this.mTickDurMs = j;
    }

    public void start(String str) {
        if (this.mEnable) {
            startQosStatTimer();
        }
    }

    public void stop() {
        if (this.mEnable) {
            stopQosStatTimer();
        }
    }
}
