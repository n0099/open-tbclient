package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int phU = -1;
    @Nullable
    private b.a phV;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> phW;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Qr(int i) {
        return this.phU == i ? com.facebook.common.references.a.b(this.phW) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Qs(int i) {
        return com.facebook.common.references.a.b(this.phW);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ah(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.phW);
        esx();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Qt(int i) {
        boolean z;
        if (i == this.phU) {
            z = com.facebook.common.references.a.a(this.phW);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        esx();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.phW.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.phW != null) {
            }
        }
        com.facebook.common.references.a.c(this.phW);
        if (this.phV != null && this.phU != -1) {
            this.phV.b(this, this.phU);
        }
        this.phW = com.facebook.common.references.a.b(aVar);
        if (this.phV != null) {
            this.phV.a(this, i);
        }
        this.phU = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void esx() {
        if (this.phV != null && this.phU != -1) {
            this.phV.b(this, this.phU);
        }
        com.facebook.common.references.a.c(this.phW);
        this.phW = null;
        this.phU = -1;
    }
}
