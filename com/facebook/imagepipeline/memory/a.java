package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class a {
    private final int gTM;
    private final com.facebook.common.references.c<Bitmap> kkl;
    @GuardedBy("this")
    private int mCount;
    private final int mMaxSize;
    @GuardedBy("this")
    private long mSize;

    public a(int i, int i2) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        com.facebook.common.internal.g.checkArgument(i2 > 0);
        this.gTM = i;
        this.mMaxSize = i2;
        this.kkl = new com.facebook.common.references.c<Bitmap>() { // from class: com.facebook.imagepipeline.memory.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: Q */
            public void release(Bitmap bitmap) {
                try {
                    a.this.U(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized boolean T(Bitmap bitmap) {
        boolean z;
        int aa = com.facebook.d.a.aa(bitmap);
        if (this.mCount < this.gTM) {
            if (this.mSize + aa <= this.mMaxSize) {
                this.mCount++;
                this.mSize = aa + this.mSize;
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void U(Bitmap bitmap) {
        synchronized (this) {
            int aa = com.facebook.d.a.aa(bitmap);
            com.facebook.common.internal.g.checkArgument(this.mCount > 0, "No bitmaps registered.");
            com.facebook.common.internal.g.b(((long) aa) <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(aa), Long.valueOf(this.mSize));
            this.mSize -= aa;
            this.mCount--;
        }
    }

    public com.facebook.common.references.c<Bitmap> cIa() {
        return this.kkl;
    }
}
