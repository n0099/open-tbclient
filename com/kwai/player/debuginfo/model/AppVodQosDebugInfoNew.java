package com.kwai.player.debuginfo.model;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes4.dex */
public class AppVodQosDebugInfoNew {
    public static final int VodQosDebugInfoMediaType_KFLV = 2;
    public static final int VodQosDebugInfoMediaType_LIVE = 1;
    public static final int VodQosDebugInfoMediaType_VOD = 0;
    public int alivePlayerCnt;
    public String autoTestTags;
    public String avQueueStatus;
    public long bitrate;
    public String blockStatus;
    public String cacheCurrentReadingUri;
    public String cacheDataSourceType;
    public long cacheDownloadedBytes;
    public boolean cacheEnabled;
    public int cacheErrorCode;
    public boolean cacheIsReadingCachedFile;
    public int cacheReopenCntBySeek;
    public int cacheStopReason;
    public long cacheTotalBytes;
    public String cacheV2Info;
    public String cpuInfo;
    public long currentPositionMs;
    public String currentState;
    public boolean dccAlgConfigEnabled;
    public String dccAlgStatus;
    public boolean dccAlgUsed;
    public String dccStatus;
    public String domain;
    public int downloadCurrentSpeedKbps;
    public String downloadSpeedInfo;
    public String dropFrame;
    public int ffpLoopCnt;
    public String firstScreenStepCostInfo;
    public long firstScreenWithoutAppCost;
    public String fullErrorMsg;
    public String host;
    public String httpVersion;
    public int lastError;
    public int mediaType;
    public String memoryInfo;
    public String metaAudioDecoderInfo;
    public String metaComment;
    public long metaDurationMs;
    public float metaFps;
    public int metaHeight;
    public String metaVideoDecoderInfo;
    public int metaWidth;
    public int playableDurationMs;
    public String playerConfigInfo;
    public boolean preLoadFinish;
    public int preLoadMs;
    public int preLoadedMsWhenAbort;
    public String serverIp;
    public String startPlayBlockStatus;
    public boolean startPlayBlockUsed;
    public long totalCostFirstScreen;
    public String transcodeType;
    public boolean usePreLoad;
    public String vodAdaptiveInfo;
    public boolean vodP2spEnabled;
    public String vodP2spStatus;

    public String getPrettyDownloadSpeedInfo() {
        return this.downloadSpeedInfo;
    }
}
