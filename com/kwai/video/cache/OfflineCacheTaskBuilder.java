package com.kwai.video.cache;

import com.kwai.video.cache.AwesomeCache;
/* loaded from: classes6.dex */
public class OfflineCacheTaskBuilder extends OfflineCacheTaskBuilderBase {
    public OfflineCacheTaskBuilder(String str, String str2, String str3, AwesomeCacheCallback awesomeCacheCallback) {
        AwesomeCache.OfflineCacheDataSpec offlineCacheDataSpec = this.mDataSpec;
        offlineCacheDataSpec.url = str;
        offlineCacheDataSpec.host = str3;
        offlineCacheDataSpec.key = str2;
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public OfflineCacheVodTask build() {
        return AwesomeCache.newOfflineCacheVodFileTask(this.mDataSpec, this.mAwesomeCacheCallback);
    }
}
