package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a {
    private final int iMR;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;
    private final com.facebook.common.references.c<Bitmap> mxG;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.iMR = i;
        this.mMaxSize = i2;
        this.mxG = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: V */
            public void release(Bitmap bitmap) {
                try {
                    a.this.Z(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean Y(Bitmap bitmap) {
        boolean z;
        int ag = com.facebook.d.a.ag(bitmap);
        if (this.mCount < this.iMR) {
            if (this.mSize + ag <= this.mMaxSize) {
                this.mCount++;
                this.mSize = ag + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void Z(Bitmap bitmap) {
        synchronized (this) {
            int ag = com.facebook.d.a.ag(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.checkArgument(((long) ag) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ag), Long.valueOf(this.mSize));
            this.mSize -= ag;
            this.mCount--;
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int bvJ() {
        return this.iMR;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.c<Bitmap> dAA() {
        return this.mxG;
    }
}
