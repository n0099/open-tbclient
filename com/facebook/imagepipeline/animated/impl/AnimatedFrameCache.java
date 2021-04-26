package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class AnimatedFrameCache {
    public final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    public final CacheKey mImageCacheKey;
    @GuardedBy("this")
    public final LinkedHashSet<CacheKey> mFreeItemsPool = new LinkedHashSet<>();
    public final CountingMemoryCache.EntryStateObserver<CacheKey> mEntryStateObserver = new CountingMemoryCache.EntryStateObserver<CacheKey>() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver
        public void onExclusivityChanged(CacheKey cacheKey, boolean z) {
            AnimatedFrameCache.this.onReusabilityChange(cacheKey, z);
        }
    };

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class FrameKey implements CacheKey {
        public final int mFrameIndex;
        public final CacheKey mImageCacheKey;

        public FrameKey(CacheKey cacheKey, int i2) {
            this.mImageCacheKey = cacheKey;
            this.mFrameIndex = i2;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri uri) {
            return this.mImageCacheKey.containsUri(uri);
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof FrameKey) {
                FrameKey frameKey = (FrameKey) obj;
                return this.mFrameIndex == frameKey.mFrameIndex && this.mImageCacheKey.equals(frameKey.mImageCacheKey);
            }
            return false;
        }

        @Override // com.facebook.cache.common.CacheKey
        @Nullable
        public String getUriString() {
            return null;
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.mImageCacheKey.hashCode() * 1013) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String toString() {
            return Objects.toStringHelper(this).add("imageCacheKey", this.mImageCacheKey).add("frameIndex", this.mFrameIndex).toString();
        }
    }

    public AnimatedFrameCache(CacheKey cacheKey, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        this.mImageCacheKey = cacheKey;
        this.mBackingCache = countingMemoryCache;
    }

    private FrameKey keyFor(int i2) {
        return new FrameKey(this.mImageCacheKey, i2);
    }

    @Nullable
    private synchronized CacheKey popFirstFreeItemKey() {
        CacheKey cacheKey;
        cacheKey = null;
        Iterator<CacheKey> it = this.mFreeItemsPool.iterator();
        if (it.hasNext()) {
            cacheKey = it.next();
            it.remove();
        }
        return cacheKey;
    }

    @Nullable
    public CloseableReference<CloseableImage> cache(int i2, CloseableReference<CloseableImage> closeableReference) {
        return this.mBackingCache.cache(keyFor(i2), closeableReference, this.mEntryStateObserver);
    }

    public boolean contains(int i2) {
        return this.mBackingCache.contains((CountingMemoryCache<CacheKey, CloseableImage>) keyFor(i2));
    }

    @Nullable
    public CloseableReference<CloseableImage> get(int i2) {
        return this.mBackingCache.get(keyFor(i2));
    }

    @Nullable
    public CloseableReference<CloseableImage> getForReuse() {
        CloseableReference<CloseableImage> reuse;
        do {
            CacheKey popFirstFreeItemKey = popFirstFreeItemKey();
            if (popFirstFreeItemKey == null) {
                return null;
            }
            reuse = this.mBackingCache.reuse(popFirstFreeItemKey);
        } while (reuse == null);
        return reuse;
    }

    public synchronized void onReusabilityChange(CacheKey cacheKey, boolean z) {
        if (z) {
            this.mFreeItemsPool.add(cacheKey);
        } else {
            this.mFreeItemsPool.remove(cacheKey);
        }
    }
}
