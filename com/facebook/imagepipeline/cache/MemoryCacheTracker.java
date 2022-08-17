package com.facebook.imagepipeline.cache;
/* loaded from: classes4.dex */
public interface MemoryCacheTracker<K> {
    void onCacheHit(K k);

    void onCacheMiss(K k);

    void onCachePut(K k);
}
