package com.kwai.player.debuginfo.model;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes3.dex */
public class AppLiveQosDebugInfoNew {
    public int acType;
    public String aencInit;
    public long audioBitrate;
    public int audioBufferByteLength;
    public int audioBufferTimeLength;
    public String audioDecoder;
    public int audioDelay;
    public long audioTotalDataSize;
    public int blockCnt;
    public long blockDuration;
    public long cdnDownloadBytes;
    public int cdnSwitchAttempts;
    public int cdnSwitchDurationMs;
    public int cdnSwitchSuccessAttempts;
    public long cdnUsedBytes;
    public String comment;
    public String cpuInfo;
    public String dataSourceType;
    public long decodedDataSize;
    public String firstScreenStepCostInfo;
    public int firstScreenTimeDroppedDuration;
    public long firstScreenTimeTotal;
    public int height;
    public String host;
    public String hostInfo;
    public boolean isLiveManifest;
    public int kflvBandwidthCurrent;
    public int kflvBandwidthFragment;
    public int kflvCurrentBufferMs;
    public int kflvEstimateBufferMs;
    public int kflvPlayingBitrate;
    public int kflvPredictedBufferMs;
    public int kflvSpeedupThresholdMs;
    public String memoryInfo;
    public long p2spDownloadBytes;
    public int p2spEnabled;
    public int p2spSwitchAttempts;
    public int p2spSwitchDurationMs;
    public int p2spSwitchSuccessAttempts;
    public long p2spUsedBytes;
    public String playUrl;
    public int sourceDeviceType;
    public int speedupThresholdMs;
    public long totalDataSize;
    public int totalDroppedDuration;
    public String upstreamType;
    public String vencDynamic;
    public String vencInit;
    public long videoBitrate;
    public int videoBufferByteLength;
    public int videoBufferTimeLength;
    public float videoDecodeFramesPerSecond;
    public String videoDecoder;
    public int videoDelayAftDec;
    public int videoDelayBefDec;
    public int videoDelayRecv;
    public int videoDelayRender;
    public float videoDisplayFramesPerSecond;
    public float videoReadFramesPerSecond;
    public long videoTotalDataSize;
    public int width;

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
