package com.kwai.video.cache;

import com.kwai.video.cache.AwesomeCache;
/* loaded from: classes6.dex */
public class OfflineCacheTaskBuilderBase {
    public static final int DEFAULT_CONNECT_TIMEOUT_MS = 3000;
    public static final int DEFAULT_READ_TIMEOUT_MS = 5000;
    public static final int DURATION_UNSET = -1;
    public static final int LENGTH_UNSET = -1;
    public static final int MAX_CONNECT_TIMEOUT_MS = 120000;
    public static final int MAX_READ_TIMEOUT_MS = 120000;
    public static final int MIN_CONNECT_TIMEOUT_MS = 500;
    public static final int MIN_READ_TIMEOUT_MS = 500;
    public static final int SOCKET_BUF_SIZE_UNSET = -1;
    public AwesomeCacheCallback mAwesomeCacheCallback;
    public AwesomeCache.OfflineCacheDataSpec mDataSpec;

    public OfflineCacheTaskBuilderBase() {
        AwesomeCache.OfflineCacheDataSpec offlineCacheDataSpec = new AwesomeCache.OfflineCacheDataSpec();
        this.mDataSpec = offlineCacheDataSpec;
        offlineCacheDataSpec.cacheMode = 0;
        offlineCacheDataSpec.pos = 0L;
        offlineCacheDataSpec.len = -1L;
        offlineCacheDataSpec.durMs = -1L;
        offlineCacheDataSpec.connectTimeoutMs = 3000;
        offlineCacheDataSpec.readTimeoutMs = 5000;
        offlineCacheDataSpec.socketBufSizeKb = -1;
        offlineCacheDataSpec.maxSpeedKbps = -1;
        offlineCacheDataSpec.enableLimitSpeedWhenCancel = false;
        offlineCacheDataSpec.bandWidthThreshold = -1;
    }

    public OfflineCacheTaskBuilderBase enableLimitSpeedWhenCancel(boolean z) {
        if (z) {
            this.mDataSpec.enableLimitSpeedWhenCancel = z;
        }
        return this;
    }

    public OfflineCacheTaskBuilderBase setBandWidthThreshold(int i) {
        if (i > 0) {
            this.mDataSpec.bandWidthThreshold = i;
        }
        return this;
    }

    public OfflineCacheTaskBuilderBase setCacheMode(int i) {
        this.mDataSpec.cacheMode = i;
        return this;
    }

    public OfflineCacheTaskBuilderBase setConnectTimeoutMs(int i) {
        if (i >= 500 && i <= 120000) {
            this.mDataSpec.connectTimeoutMs = i;
        }
        return this;
    }

    public OfflineCacheTaskBuilderBase setLen(long j) {
        this.mDataSpec.len = j;
        return this;
    }

    public OfflineCacheTaskBuilderBase setMaxSpeedKbps(int i) {
        if (i > 0) {
            this.mDataSpec.maxSpeedKbps = i;
        }
        return this;
    }

    public OfflineCacheTaskBuilderBase setPos(long j) {
        this.mDataSpec.pos = j;
        return this;
    }

    public OfflineCacheTaskBuilderBase setPreloadDurationMs(long j) {
        this.mDataSpec.durMs = j;
        return this;
    }

    public OfflineCacheTaskBuilderBase setReadTimeoutMs(int i) {
        if (i >= 500 && i <= 120000) {
            this.mDataSpec.readTimeoutMs = i;
        }
        return this;
    }

    public OfflineCacheTaskBuilderBase setSocketBufSizeKb(int i) {
        if (i > 0) {
            this.mDataSpec.socketBufSizeKb = i;
        }
        return this;
    }
}
