package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int mOX = -1;
    @Nullable
    private b.a mOY;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> mOZ;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Iw(int i) {
        return this.mOX == i ? com.facebook.common.references.a.b(this.mOZ) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ix(int i) {
        return com.facebook.common.references.a.b(this.mOZ);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.mOZ);
        dBT();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Iy(int i) {
        boolean z;
        if (i == this.mOX) {
            z = com.facebook.common.references.a.a(this.mOZ);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dBT();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.mOZ.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.mOZ != null) {
            }
        }
        com.facebook.common.references.a.c(this.mOZ);
        if (this.mOY != null && this.mOX != -1) {
            this.mOY.b(this, this.mOX);
        }
        this.mOZ = com.facebook.common.references.a.b(aVar);
        if (this.mOY != null) {
            this.mOY.a(this, i);
        }
        this.mOX = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dBT() {
        if (this.mOY != null && this.mOX != -1) {
            this.mOY.b(this, this.mOX);
        }
        com.facebook.common.references.a.c(this.mOZ);
        this.mOZ = null;
        this.mOX = -1;
    }
}
