package com.kwai.video.cache;
/* loaded from: classes3.dex */
public class OfflineCacheTaskBuilder extends OfflineCacheTaskBuilderBase {
    public OfflineCacheTaskBuilder(String str, String str2, String str3, AwesomeCacheCallback awesomeCacheCallback) {
        this.mDataSpec.url = str;
        this.mDataSpec.host = str3;
        this.mDataSpec.key = str2;
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public OfflineCacheVodTask build() {
        return AwesomeCache.newOfflineCacheVodFileTask(this.mDataSpec, this.mAwesomeCacheCallback);
    }
}
