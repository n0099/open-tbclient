package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class b implements com.facebook.fresco.animation.b.b {
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> pHA;
    private int pHy = -1;
    @Nullable
    private b.a pHz;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Py(int i) {
        return this.pHy == i ? com.facebook.common.references.a.b(this.pHA) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pz(int i) {
        return com.facebook.common.references.a.b(this.pHA);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ai(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.pHA);
        evz();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean PA(int i) {
        boolean z;
        if (i == this.pHy) {
            z = com.facebook.common.references.a.a(this.pHA);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        evz();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.pHA.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.pHA != null) {
            }
        }
        com.facebook.common.references.a.c(this.pHA);
        if (this.pHz != null && this.pHy != -1) {
            this.pHz.b(this, this.pHy);
        }
        this.pHA = com.facebook.common.references.a.b(aVar);
        if (this.pHz != null) {
            this.pHz.a(this, i);
        }
        this.pHy = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void evz() {
        if (this.pHz != null && this.pHy != -1) {
            this.pHz.b(this, this.pHy);
        }
        com.facebook.common.references.a.c(this.pHA);
        this.pHA = null;
        this.pHy = -1;
    }
}
