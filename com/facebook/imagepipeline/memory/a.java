package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes25.dex */
public class a {
    private final int jKK;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;
    private final com.facebook.common.references.c<Bitmap> nHi;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.jKK = i;
        this.mMaxSize = i2;
        this.nHi = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: X */
            public void release(Bitmap bitmap) {
                try {
                    a.this.ab(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean aa(Bitmap bitmap) {
        boolean z;
        int ai = com.facebook.d.a.ai(bitmap);
        if (this.mCount < this.jKK) {
            if (this.mSize + ai <= this.mMaxSize) {
                this.mCount++;
                this.mSize = ai + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void ab(Bitmap bitmap) {
        synchronized (this) {
            int ai = com.facebook.d.a.ai(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.checkArgument(((long) ai) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ai), Long.valueOf(this.mSize));
            this.mSize -= ai;
            this.mCount--;
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int bMA() {
        return this.jKK;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.c<Bitmap> dYN() {
        return this.nHi;
    }
}
