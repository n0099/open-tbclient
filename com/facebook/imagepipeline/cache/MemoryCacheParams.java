package com.facebook.imagepipeline.cache;
/* loaded from: classes6.dex */
public class MemoryCacheParams {
    public final int maxCacheEntries;
    public final int maxCacheEntrySize;
    public final int maxCacheSize;
    public final int maxEvictionQueueEntries;
    public final int maxEvictionQueueSize;

    public MemoryCacheParams(int i2, int i3, int i4, int i5, int i6) {
        this.maxCacheSize = i2;
        this.maxCacheEntries = i3;
        this.maxEvictionQueueSize = i4;
        this.maxEvictionQueueEntries = i5;
        this.maxCacheEntrySize = i6;
    }
}
