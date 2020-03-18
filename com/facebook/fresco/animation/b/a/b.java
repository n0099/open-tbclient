package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lQm = -1;
    @Nullable
    private b.a lQn;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lQo;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ia(int i) {
        return this.lQm == i ? com.facebook.common.references.a.b((com.facebook.common.references.a) this.lQo) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ib(int i) {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lQo);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ad(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lQo);
        dnQ();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Ic(int i) {
        boolean z;
        if (i == this.lQm) {
            z = com.facebook.common.references.a.a(this.lQo);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dnQ();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lQo.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lQo != null) {
            }
        }
        com.facebook.common.references.a.c(this.lQo);
        if (this.lQn != null && this.lQm != -1) {
            this.lQn.b(this, this.lQm);
        }
        this.lQo = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        if (this.lQn != null) {
            this.lQn.a(this, i);
        }
        this.lQm = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dnQ() {
        if (this.lQn != null && this.lQm != -1) {
            this.lQn.b(this, this.lQm);
        }
        com.facebook.common.references.a.c(this.lQo);
        this.lQo = null;
        this.lQm = -1;
    }
}
