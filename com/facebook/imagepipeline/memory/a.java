package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a {
    private final int iyk;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;
    private final com.facebook.common.references.c<Bitmap> mdP;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.iyk = i;
        this.mMaxSize = i2;
        this.mdP = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: T */
            public void release(Bitmap bitmap) {
                try {
                    a.this.X(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean W(Bitmap bitmap) {
        boolean z;
        int ae = com.facebook.d.a.ae(bitmap);
        if (this.mCount < this.iyk) {
            if (this.mSize + ae <= this.mMaxSize) {
                this.mCount++;
                this.mSize = ae + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void X(Bitmap bitmap) {
        synchronized (this) {
            int ae = com.facebook.d.a.ae(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.checkArgument(((long) ae) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ae), Long.valueOf(this.mSize));
            this.mSize -= ae;
            this.mCount--;
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int dti() {
        return this.iyk;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.c<Bitmap> dtj() {
        return this.mdP;
    }
}
