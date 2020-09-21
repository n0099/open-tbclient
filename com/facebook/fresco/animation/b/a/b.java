package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int nBr = -1;
    @Nullable
    private b.a nBs;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> nBt;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ma(int i) {
        return this.nBr == i ? com.facebook.common.references.a.b(this.nBt) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Mb(int i) {
        return com.facebook.common.references.a.b(this.nBt);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.nBt);
        dVq();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Mc(int i) {
        boolean z;
        if (i == this.nBr) {
            z = com.facebook.common.references.a.a(this.nBt);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dVq();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.nBt.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.nBt != null) {
            }
        }
        com.facebook.common.references.a.c(this.nBt);
        if (this.nBs != null && this.nBr != -1) {
            this.nBs.b(this, this.nBr);
        }
        this.nBt = com.facebook.common.references.a.b(aVar);
        if (this.nBs != null) {
            this.nBs.a(this, i);
        }
        this.nBr = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dVq() {
        if (this.nBs != null && this.nBr != -1) {
            this.nBs.b(this, this.nBr);
        }
        com.facebook.common.references.a.c(this.nBt);
        this.nBt = null;
        this.nBr = -1;
    }
}
