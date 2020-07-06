package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int mPa = -1;
    @Nullable
    private b.a mPb;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> mPc;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Iw(int i) {
        return this.mPa == i ? com.facebook.common.references.a.b(this.mPc) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ix(int i) {
        return com.facebook.common.references.a.b(this.mPc);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.mPc);
        dBX();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Iy(int i) {
        boolean z;
        if (i == this.mPa) {
            z = com.facebook.common.references.a.a(this.mPc);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dBX();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.mPc.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.mPc != null) {
            }
        }
        com.facebook.common.references.a.c(this.mPc);
        if (this.mPb != null && this.mPa != -1) {
            this.mPb.b(this, this.mPa);
        }
        this.mPc = com.facebook.common.references.a.b(aVar);
        if (this.mPb != null) {
            this.mPb.a(this, i);
        }
        this.mPa = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dBX() {
        if (this.mPb != null && this.mPa != -1) {
            this.mPb.b(this, this.mPa);
        }
        com.facebook.common.references.a.c(this.mPc);
        this.mPc = null;
        this.mPa = -1;
    }
}
