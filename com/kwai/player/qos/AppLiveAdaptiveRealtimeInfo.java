package com.kwai.player.qos;

import android.os.Bundle;
import androidx.annotation.Keep;
@Keep
/* loaded from: classes5.dex */
public class AppLiveAdaptiveRealtimeInfo {
    private static final String LiveAdaptiveRealtimeInfo_audioBufferTime = "audioBufferTime";
    private static final String LiveAdaptiveRealtimeInfo_bandwidthCurrent = "bandwidthCurrent";
    private static final String LiveAdaptiveRealtimeInfo_bandwidthFragment = "bandwidthFragment";
    private static final String LiveAdaptiveRealtimeInfo_bitrateDownloading = "bitrateDownloading";
    private static final String LiveAdaptiveRealtimeInfo_bitratePlaying = "bitratePlaying";
    private static final String LiveAdaptiveRealtimeInfo_cachedTagDurationMs = "cachedTagDurationMs";
    private static final String LiveAdaptiveRealtimeInfo_cachedTotalDurationMs = "cachedTotalDurationMs";
    private static final String LiveAdaptiveRealtimeInfo_curRepFirstDataTime = "curRepFirstDataTime";
    private static final String LiveAdaptiveRealtimeInfo_curRepReadStartTime = "curRepReadStartTime";
    private static final String LiveAdaptiveRealtimeInfo_curRepStartTime = "curRepStartTime";
    private static final String LiveAdaptiveRealtimeInfo_currentBufferMs = "currentBufferMs";
    private static final String LiveAdaptiveRealtimeInfo_estimateBufferMs = "estimateBufferMs";
    private static final String LiveAdaptiveRealtimeInfo_predictedBufferMs = "predictedBufferMs";
    private static final String LiveAdaptiveRealtimeInfo_repSwitchCnt = "repSwitchCnt";
    private static final String LiveAdaptiveRealtimeInfo_repSwitchGapTime = "repSwitchGapTime";
    private static final String LiveAdaptiveRealtimeInfo_repSwitchPointVideoBufferTime = "repSwitchPointVideoBufferTime";
    private static final String LiveAdaptiveRealtimeInfo_videoBufferTime = "videoBufferTime";
    public long audioBufferTime;
    public int bandwidthCurrent;
    public int bandwidthFragment;
    public int bitrateDownloading;
    public int bitratePlaying;
    public long cachedTagDurationMs;
    public long cachedTotalDurationMs;
    public long curRepFirstDataTime;
    public long curRepReadStartTime;
    public long curRepStartTime;
    public int currentBufferMs;
    public int estimateBufferMs;
    public int predictedBufferMs;
    public int repSwitchCnt;
    public long repSwitchGapTime;
    public int repSwitchPointVideoBufferTime;
    public long videoBufferTime;

    public static AppLiveAdaptiveRealtimeInfo from(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        AppLiveAdaptiveRealtimeInfo appLiveAdaptiveRealtimeInfo = new AppLiveAdaptiveRealtimeInfo();
        appLiveAdaptiveRealtimeInfo.videoBufferTime = bundle.getLong(LiveAdaptiveRealtimeInfo_videoBufferTime, 0L);
        appLiveAdaptiveRealtimeInfo.audioBufferTime = bundle.getLong(LiveAdaptiveRealtimeInfo_audioBufferTime, 0L);
        appLiveAdaptiveRealtimeInfo.bandwidthCurrent = bundle.getInt(LiveAdaptiveRealtimeInfo_bandwidthCurrent, 0);
        appLiveAdaptiveRealtimeInfo.bandwidthFragment = bundle.getInt(LiveAdaptiveRealtimeInfo_bandwidthFragment, 0);
        appLiveAdaptiveRealtimeInfo.bitrateDownloading = bundle.getInt(LiveAdaptiveRealtimeInfo_bitrateDownloading, 0);
        appLiveAdaptiveRealtimeInfo.bitratePlaying = bundle.getInt(LiveAdaptiveRealtimeInfo_bitratePlaying, 0);
        appLiveAdaptiveRealtimeInfo.currentBufferMs = bundle.getInt(LiveAdaptiveRealtimeInfo_currentBufferMs, 0);
        appLiveAdaptiveRealtimeInfo.estimateBufferMs = bundle.getInt(LiveAdaptiveRealtimeInfo_estimateBufferMs, 0);
        appLiveAdaptiveRealtimeInfo.predictedBufferMs = bundle.getInt(LiveAdaptiveRealtimeInfo_predictedBufferMs, 0);
        appLiveAdaptiveRealtimeInfo.curRepReadStartTime = bundle.getLong(LiveAdaptiveRealtimeInfo_curRepReadStartTime, 0L);
        appLiveAdaptiveRealtimeInfo.curRepFirstDataTime = bundle.getLong(LiveAdaptiveRealtimeInfo_curRepFirstDataTime, 0L);
        appLiveAdaptiveRealtimeInfo.curRepStartTime = bundle.getLong(LiveAdaptiveRealtimeInfo_curRepStartTime, 0L);
        appLiveAdaptiveRealtimeInfo.repSwitchGapTime = bundle.getLong(LiveAdaptiveRealtimeInfo_repSwitchGapTime, 0L);
        appLiveAdaptiveRealtimeInfo.repSwitchCnt = bundle.getInt(LiveAdaptiveRealtimeInfo_repSwitchCnt, 0);
        appLiveAdaptiveRealtimeInfo.repSwitchPointVideoBufferTime = bundle.getInt(LiveAdaptiveRealtimeInfo_repSwitchPointVideoBufferTime, 0);
        appLiveAdaptiveRealtimeInfo.cachedTagDurationMs = bundle.getLong(LiveAdaptiveRealtimeInfo_cachedTagDurationMs, 0L);
        appLiveAdaptiveRealtimeInfo.cachedTotalDurationMs = bundle.getLong(LiveAdaptiveRealtimeInfo_cachedTotalDurationMs, 0L);
        return appLiveAdaptiveRealtimeInfo;
    }
}
