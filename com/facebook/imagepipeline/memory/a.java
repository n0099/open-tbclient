package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class a {
    @GuardedBy("this")
    private int mCount;
    private final int mMaxCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;
    private final com.facebook.common.references.c<Bitmap> pAo;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.mMaxCount = i;
        this.mMaxSize = i2;
        this.pAo = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(Bitmap bitmap) {
                try {
                    a.this.ad(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean ac(Bitmap bitmap) {
        boolean z;
        int ak = com.facebook.d.a.ak(bitmap);
        if (this.mCount < this.mMaxCount) {
            if (this.mSize + ak <= this.mMaxSize) {
                this.mCount++;
                this.mSize = ak + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void ad(Bitmap bitmap) {
        synchronized (this) {
            int ak = com.facebook.d.a.ak(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.checkArgument(((long) ak) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ak), Long.valueOf(this.mSize));
            this.mSize -= ak;
            this.mCount--;
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int bXe() {
        return this.mMaxCount;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.c<Bitmap> ewh() {
        return this.pAo;
    }
}
