package com.facebook.imagepipeline.cache;
/* loaded from: classes12.dex */
public interface MemoryCacheTracker<K> {
    void onCacheHit(K k2);

    void onCacheMiss();

    void onCachePut();
}
