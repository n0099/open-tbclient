package com.facebook.imagepipeline.cache;
/* loaded from: classes3.dex */
public interface MemoryCacheTracker<K> {
    void onCacheHit(K k);

    void onCacheMiss();

    void onCachePut();
}
