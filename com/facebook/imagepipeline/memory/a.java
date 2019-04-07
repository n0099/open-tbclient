package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class a {
    @GuardedBy("this")
    private long aSR;
    private final int gvA;
    private final com.facebook.common.references.c<Bitmap> jIx;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.gvA = i;
        this.mMaxSize = i2;
        this.jIx = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: R */
            public void release(Bitmap bitmap) {
                try {
                    a.this.V(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean U(Bitmap bitmap) {
        boolean z;
        int ab = com.facebook.d.a.ab(bitmap);
        if (this.mCount < this.gvA) {
            if (this.aSR + ab <= this.mMaxSize) {
                this.mCount++;
                this.aSR = ab + this.aSR;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void V(Bitmap bitmap) {
        synchronized (this) {
            int ab = com.facebook.d.a.ab(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.b(((long) ab) <= this.aSR, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ab), Long.valueOf(this.aSR));
            this.aSR -= ab;
            this.mCount--;
        }
    }

    public com.facebook.common.references.c<Bitmap> cyT() {
        return this.jIx;
    }
}
