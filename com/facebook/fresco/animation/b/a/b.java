package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int nrt = -1;
    @Nullable
    private b.a nru;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> nrv;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Lv(int i) {
        return this.nrt == i ? com.facebook.common.references.a.b(this.nrv) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Lw(int i) {
        return com.facebook.common.references.a.b(this.nrv);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ab(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.nrv);
        dRs();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Lx(int i) {
        boolean z;
        if (i == this.nrt) {
            z = com.facebook.common.references.a.a(this.nrv);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dRs();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.nrv.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.nrv != null) {
            }
        }
        com.facebook.common.references.a.c(this.nrv);
        if (this.nru != null && this.nrt != -1) {
            this.nru.b(this, this.nrt);
        }
        this.nrv = com.facebook.common.references.a.b(aVar);
        if (this.nru != null) {
            this.nru.a(this, i);
        }
        this.nrt = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dRs() {
        if (this.nru != null && this.nrt != -1) {
            this.nru.b(this, this.nrt);
        }
        com.facebook.common.references.a.c(this.nrv);
        this.nrv = null;
        this.nrt = -1;
    }
}
