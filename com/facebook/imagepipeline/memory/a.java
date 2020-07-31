package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class a {
    private final int jnc;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;
    private final com.facebook.common.references.c<Bitmap> ndb;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.jnc = i;
        this.mMaxSize = i2;
        this.ndb = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: Y */
            public void release(Bitmap bitmap) {
                try {
                    a.this.ac(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean ab(Bitmap bitmap) {
        boolean z;
        int aj = com.facebook.d.a.aj(bitmap);
        if (this.mCount < this.jnc) {
            if (this.mSize + aj <= this.mMaxSize) {
                this.mCount++;
                this.mSize = aj + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void ac(Bitmap bitmap) {
        synchronized (this) {
            int aj = com.facebook.d.a.aj(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.checkArgument(((long) aj) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(aj), Long.valueOf(this.mSize));
            this.mSize -= aj;
            this.mCount--;
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized int bBV() {
        return this.jnc;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public com.facebook.common.references.c<Bitmap> dIG() {
        return this.ndb;
    }
}
