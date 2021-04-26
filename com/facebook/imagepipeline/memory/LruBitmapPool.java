package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class LruBitmapPool implements BitmapPool {
    public int mCurrentSize;
    public int mMaxBitmapSize;
    public final int mMaxPoolSize;
    public final PoolStatsTracker mPoolStatsTracker;
    public final PoolBackend<Bitmap> mStrategy = new BitmapPoolBackend();

    public LruBitmapPool(int i2, int i3, PoolStatsTracker poolStatsTracker, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry) {
        this.mMaxPoolSize = i2;
        this.mMaxBitmapSize = i3;
        this.mPoolStatsTracker = poolStatsTracker;
        if (memoryTrimmableRegistry != null) {
            memoryTrimmableRegistry.registerMemoryTrimmable(this);
        }
    }

    @VisibleForTesting
    private Bitmap alloc(int i2) {
        this.mPoolStatsTracker.onAlloc(i2);
        return Bitmap.createBitmap(1, i2, Bitmap.Config.ALPHA_8);
    }

    private synchronized void trimTo(int i2) {
        Bitmap pop;
        while (this.mCurrentSize > i2 && (pop = this.mStrategy.pop()) != null) {
            int size = this.mStrategy.getSize(pop);
            this.mCurrentSize -= size;
            this.mPoolStatsTracker.onFree(size);
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        trimTo((int) (this.mMaxPoolSize * (1.0d - memoryTrimType.getSuggestedTrimRatio())));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.memory.Pool
    public synchronized Bitmap get(int i2) {
        if (this.mCurrentSize > this.mMaxPoolSize) {
            trimTo(this.mMaxPoolSize);
        }
        Bitmap bitmap = this.mStrategy.get(i2);
        if (bitmap != null) {
            int size = this.mStrategy.getSize(bitmap);
            this.mCurrentSize -= size;
            this.mPoolStatsTracker.onValueReuse(size);
            return bitmap;
        }
        return alloc(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        int size = this.mStrategy.getSize(bitmap);
        if (size <= this.mMaxBitmapSize) {
            this.mPoolStatsTracker.onValueRelease(size);
            this.mStrategy.put(bitmap);
            synchronized (this) {
                this.mCurrentSize += size;
            }
        }
    }
}
