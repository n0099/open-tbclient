package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class a {
    private final int kmh;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;
    private final com.facebook.common.references.c<Bitmap> oNR;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.kmh = i;
        this.mMaxSize = i2;
        this.oNR = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: ab */
            public void release(Bitmap bitmap) {
                try {
                    a.this.af(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean ae(Bitmap bitmap) {
        boolean z;
        int am = com.facebook.d.a.am(bitmap);
        if (this.mCount < this.kmh) {
            if (this.mSize + am <= this.mMaxSize) {
                this.mCount++;
                this.mSize = am + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void af(Bitmap bitmap) {
        synchronized (this) {
            int am = com.facebook.d.a.am(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.checkArgument(((long) am) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(am), Long.valueOf(this.mSize));
            this.mSize -= am;
            this.mCount--;
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int bSO() {
        return this.kmh;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.c<Bitmap> emw() {
        return this.oNR;
    }
}
