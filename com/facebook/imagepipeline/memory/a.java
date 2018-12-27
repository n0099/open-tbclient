package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class a {
    private final int feT;
    private final com.facebook.common.references.c<Bitmap> isb;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.feT = i;
        this.mMaxSize = i2;
        this.isb = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: J */
            public void release(Bitmap bitmap) {
                try {
                    a.this.N(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean M(Bitmap bitmap) {
        boolean z;
        int T = com.facebook.d.a.T(bitmap);
        if (this.mCount < this.feT) {
            if (this.mSize + T <= this.mMaxSize) {
                this.mCount++;
                this.mSize = T + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void N(Bitmap bitmap) {
        synchronized (this) {
            int T = com.facebook.d.a.T(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.b(((long) T) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(T), Long.valueOf(this.mSize));
            this.mSize -= T;
            this.mCount--;
        }
    }

    public com.facebook.common.references.c<Bitmap> bZa() {
        return this.isb;
    }
}
