package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class a {
    @GuardedBy("this")
    private long aVH;
    private final int gMP;
    private final com.facebook.common.references.c<Bitmap> kbm;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.gMP = i;
        this.mMaxSize = i2;
        this.kbm = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: S */
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
        if (this.mCount < this.gMP) {
            if (this.aVH + ac <= this.mMaxSize) {
                this.mCount++;
                this.aVH = ac + this.aVH;
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
            com.facebook.common.internal.g.b(((long) ac) <= this.aVH, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(ac), Long.valueOf(this.aVH));
            this.aVH -= ac;
            this.mCount--;
        }
    }

    public com.facebook.common.references.c<Bitmap> cGR() {
        return this.kbm;
    }
}
