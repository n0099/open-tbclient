package com.kwai.video.cache;
/* loaded from: classes4.dex */
public class OfflineCacheVodAdaptiveTaskBuilder extends OfflineCacheTaskBuilderBase {
    private VodAdaptiveInit mVodAdaptiveInitValue;

    /* loaded from: classes4.dex */
    public static class VodAdaptiveInit {
        public int devResHeigh;
        public int devResWidth;
        public int lowDevice;
        public int manifestType = 0;
        public int netType;
        public String rateConfig;
        public int signalStrength;
    }

    public OfflineCacheVodAdaptiveTaskBuilder(String str, VodAdaptiveInit vodAdaptiveInit, AwesomeCacheCallback awesomeCacheCallback) {
        this.mDataSpec.url = str;
        this.mDataSpec.host = "";
        this.mDataSpec.key = "";
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public OfflineCacheVodTask build() {
        return AwesomeCache.newOfflineCacheVodAdaptiveTask(this.mDataSpec, this.mAwesomeCacheCallback, this.mVodAdaptiveInitValue);
    }
}
