package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableImage;
/* loaded from: classes4.dex */
public class BitmapMemoryCacheFactory {
    public static InstrumentedMemoryCache<CacheKey, CloseableImage> get(CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, final ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerBitmapMemoryCache(countingMemoryCache);
        return new InstrumentedMemoryCache<>(countingMemoryCache, new MemoryCacheTracker<CacheKey>() { // from class: com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheMiss() {
                ImageCacheStatsTracker.this.onBitmapCacheMiss();
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCachePut() {
                ImageCacheStatsTracker.this.onBitmapCachePut();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheHit(CacheKey cacheKey) {
                ImageCacheStatsTracker.this.onBitmapCacheHit(cacheKey);
            }
        });
    }
}
