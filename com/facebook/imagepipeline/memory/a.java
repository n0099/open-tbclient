package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class a {
    private final int hKB;
    private final com.facebook.common.references.c<Bitmap> lTv;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.hKB = i;
        this.mMaxSize = i2;
        this.lTv = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(Bitmap bitmap) {
                try {
                    a.this.W(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean V(Bitmap bitmap) {
        boolean z;
        int ad = com.facebook.d.a.ad(bitmap);
        if (this.mCount < this.hKB) {
            if (this.mSize + ad <= this.mMaxSize) {
                this.mCount++;
                this.mSize = ad + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void W(Bitmap bitmap) {
        synchronized (this) {
            int ad = com.facebook.d.a.ad(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.checkArgument(((long) ad) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ad), Long.valueOf(this.mSize));
            this.mSize -= ad;
            this.mCount--;
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int dpy() {
        return this.hKB;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.c<Bitmap> dpz() {
        return this.lTv;
    }
}
