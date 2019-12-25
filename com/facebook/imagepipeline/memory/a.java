package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public class a {
    private final int hGY;
    private final com.facebook.common.references.c<Bitmap> lPJ;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.hGY = i;
        this.mMaxSize = i2;
        this.lPJ = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
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
        int ac = com.facebook.d.a.ac(bitmap);
        if (this.mCount < this.hGY) {
            if (this.mSize + ac <= this.mMaxSize) {
                this.mCount++;
                this.mSize = ac + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void W(Bitmap bitmap) {
        synchronized (this) {
            int ac = com.facebook.d.a.ac(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.checkArgument(((long) ac) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ac), Long.valueOf(this.mSize));
            this.mSize -= ac;
            this.mCount--;
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int dop() {
        return this.hGY;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.c<Bitmap> doq() {
        return this.lPJ;
    }
}
