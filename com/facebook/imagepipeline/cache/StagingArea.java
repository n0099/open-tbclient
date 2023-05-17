package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes8.dex */
public class StagingArea {
    public static final Class<?> TAG = StagingArea.class;
    @GuardedBy("this")
    public Map<CacheKey, EncodedImage> mMap = new HashMap();

    public static StagingArea getInstance() {
        return new StagingArea();
    }

    private synchronized void logStats() {
        FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
    }

    public void clearAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mMap.values());
            this.mMap.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            EncodedImage encodedImage = (EncodedImage) arrayList.get(i);
            if (encodedImage != null) {
                encodedImage.close();
            }
        }
    }

    public synchronized boolean containsKey(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        if (!this.mMap.containsKey(cacheKey)) {
            return false;
        }
        EncodedImage encodedImage = this.mMap.get(cacheKey);
        synchronized (encodedImage) {
            if (EncodedImage.isValid(encodedImage)) {
                return true;
            }
            this.mMap.remove(cacheKey);
            FLog.w(TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
            return false;
        }
    }

    @Nullable
    public synchronized EncodedImage get(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        EncodedImage encodedImage = this.mMap.get(cacheKey);
        if (encodedImage != null) {
            synchronized (encodedImage) {
                if (!EncodedImage.isValid(encodedImage)) {
                    this.mMap.remove(cacheKey);
                    FLog.w(TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                encodedImage = EncodedImage.cloneOrNull(encodedImage);
            }
        }
        return encodedImage;
    }

    public synchronized void put(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        EncodedImage.closeSafely(this.mMap.put(cacheKey, EncodedImage.cloneOrNull(encodedImage)));
        logStats();
    }

    public boolean remove(CacheKey cacheKey) {
        EncodedImage remove;
        Preconditions.checkNotNull(cacheKey);
        synchronized (this) {
            remove = this.mMap.remove(cacheKey);
        }
        if (remove == null) {
            return false;
        }
        try {
            return remove.isValid();
        } finally {
            remove.close();
        }
    }

    public synchronized boolean remove(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkNotNull(encodedImage);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        EncodedImage encodedImage2 = this.mMap.get(cacheKey);
        if (encodedImage2 == null) {
            return false;
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage2.getByteBufferRef();
        CloseableReference<PooledByteBuffer> byteBufferRef2 = encodedImage.getByteBufferRef();
        if (byteBufferRef != null && byteBufferRef2 != null && byteBufferRef.get() == byteBufferRef2.get()) {
            this.mMap.remove(cacheKey);
            CloseableReference.closeSafely(byteBufferRef2);
            CloseableReference.closeSafely(byteBufferRef);
            EncodedImage.closeSafely(encodedImage2);
            logStats();
            return true;
        }
        CloseableReference.closeSafely(byteBufferRef2);
        CloseableReference.closeSafely(byteBufferRef);
        EncodedImage.closeSafely(encodedImage2);
        return false;
    }
}
