package com.facebook.imagepipeline.cache;
/* loaded from: classes7.dex */
public interface MemoryCacheTracker {
    void onCacheHit(Object obj);

    void onCacheMiss(Object obj);

    void onCachePut(Object obj);
}
