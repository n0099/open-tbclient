package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int pET = -1;
    @Nullable
    private b.a pEU;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> pEV;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pt(int i) {
        return this.pET == i ? com.facebook.common.references.a.b(this.pEV) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pu(int i) {
        return com.facebook.common.references.a.b(this.pEV);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ai(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b2;
        b2 = com.facebook.common.references.a.b(this.pEV);
        evi();
        return b2;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Pv(int i) {
        boolean z;
        if (i == this.pET) {
            z = com.facebook.common.references.a.a(this.pEV);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        evi();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.pEV.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.pEV != null) {
            }
        }
        com.facebook.common.references.a.c(this.pEV);
        if (this.pEU != null && this.pET != -1) {
            this.pEU.b(this, this.pET);
        }
        this.pEV = com.facebook.common.references.a.b(aVar);
        if (this.pEU != null) {
            this.pEU.a(this, i);
        }
        this.pET = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void evi() {
        if (this.pEU != null && this.pET != -1) {
            this.pEU.b(this, this.pET);
        }
        com.facebook.common.references.a.c(this.pEV);
        this.pEV = null;
        this.pET = -1;
    }
}
