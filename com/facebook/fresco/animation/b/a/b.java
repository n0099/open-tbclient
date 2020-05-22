package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int mrP = -1;
    @Nullable
    private b.a mrQ;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> mrR;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Hn(int i) {
        return this.mrP == i ? com.facebook.common.references.a.b(this.mrR) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ho(int i) {
        return com.facebook.common.references.a.b(this.mrR);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.mrR);
        dxd();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Hp(int i) {
        boolean z;
        if (i == this.mrP) {
            z = com.facebook.common.references.a.a(this.mrR);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dxd();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.mrR.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.mrR != null) {
            }
        }
        com.facebook.common.references.a.c(this.mrR);
        if (this.mrQ != null && this.mrP != -1) {
            this.mrQ.b(this, this.mrP);
        }
        this.mrR = com.facebook.common.references.a.b(aVar);
        if (this.mrQ != null) {
            this.mrQ.a(this, i);
        }
        this.mrP = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dxd() {
        if (this.mrQ != null && this.mrP != -1) {
            this.mrQ.b(this, this.mrP);
        }
        com.facebook.common.references.a.c(this.mrR);
        this.mrR = null;
        this.mrP = -1;
    }
}
