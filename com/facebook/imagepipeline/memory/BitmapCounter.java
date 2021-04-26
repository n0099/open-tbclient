package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class BitmapCounter {
    @GuardedBy("this")
    public int mCount;
    public final int mMaxCount;
    public final int mMaxSize;
    @GuardedBy("this")
    public long mSize;
    public final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

    public BitmapCounter(int i2, int i3) {
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i3 > 0);
        this.mMaxCount = i2;
        this.mMaxSize = i3;
        this.mUnpooledBitmapsReleaser = new ResourceReleaser<Bitmap>() { // from class: com.facebook.imagepipeline.memory.BitmapCounter.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Bitmap bitmap) {
                try {
                    BitmapCounter.this.decrease(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized void decrease(Bitmap bitmap) {
        int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
        Preconditions.checkArgument(this.mCount > 0, "No bitmaps registered.");
        long j = sizeInBytes;
        Preconditions.checkArgument(j <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(sizeInBytes), Long.valueOf(this.mSize));
        this.mSize -= j;
        this.mCount--;
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized int getMaxCount() {
        return this.mMaxCount;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public ResourceReleaser<Bitmap> getReleaser() {
        return this.mUnpooledBitmapsReleaser;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized boolean increase(Bitmap bitmap) {
        int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
        if (this.mCount < this.mMaxCount) {
            long j = sizeInBytes;
            if (this.mSize + j <= this.mMaxSize) {
                this.mCount++;
                this.mSize += j;
                return true;
            }
        }
        return false;
    }
}
