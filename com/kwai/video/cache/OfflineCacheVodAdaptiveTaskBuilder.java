package com.kwai.video.cache;

import com.kwai.video.cache.AwesomeCache;
/* loaded from: classes6.dex */
public class OfflineCacheVodAdaptiveTaskBuilder extends OfflineCacheTaskBuilderBase {
    public VodAdaptiveInit mVodAdaptiveInitValue;

    /* loaded from: classes6.dex */
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
        AwesomeCache.OfflineCacheDataSpec offlineCacheDataSpec = this.mDataSpec;
        offlineCacheDataSpec.url = str;
        offlineCacheDataSpec.host = "";
        offlineCacheDataSpec.key = "";
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public OfflineCacheVodTask build() {
        return AwesomeCache.newOfflineCacheVodAdaptiveTask(this.mDataSpec, this.mAwesomeCacheCallback, this.mVodAdaptiveInitValue);
    }
}
