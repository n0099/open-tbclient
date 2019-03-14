package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class a {
    @GuardedBy("this")
    private long aSO;
    private final int gvN;
    private final com.facebook.common.references.c<Bitmap> jJd;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.gvN = i;
        this.mMaxSize = i2;
        this.jJd = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
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
        if (this.mCount < this.gvN) {
            if (this.aSO + ab <= this.mMaxSize) {
                this.mCount++;
                this.aSO = ab + this.aSO;
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
            com.facebook.common.internal.g.b(((long) ab) <= this.aSO, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ab), Long.valueOf(this.aSO));
            this.aSO -= ab;
            this.mCount--;
        }
    }

    public com.facebook.common.references.c<Bitmap> cza() {
        return this.jJd;
    }
}
