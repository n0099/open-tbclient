package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int pFt = -1;
    @Nullable
    private b.a pFu;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> pFv;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pu(int i) {
        return this.pFt == i ? com.facebook.common.references.a.b(this.pFv) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pv(int i) {
        return com.facebook.common.references.a.b(this.pFv);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ai(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b2;
        b2 = com.facebook.common.references.a.b(this.pFv);
        evq();
        return b2;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Pw(int i) {
        boolean z;
        if (i == this.pFt) {
            z = com.facebook.common.references.a.a(this.pFv);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        evq();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.pFv.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.pFv != null) {
            }
        }
        com.facebook.common.references.a.c(this.pFv);
        if (this.pFu != null && this.pFt != -1) {
            this.pFu.b(this, this.pFt);
        }
        this.pFv = com.facebook.common.references.a.b(aVar);
        if (this.pFu != null) {
            this.pFu.a(this, i);
        }
        this.pFt = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void evq() {
        if (this.pFu != null && this.pFt != -1) {
            this.pFu.b(this, this.pFt);
        }
        com.facebook.common.references.a.c(this.pFv);
        this.pFv = null;
        this.pFt = -1;
    }
}
