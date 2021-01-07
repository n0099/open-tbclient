package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int pzl = -1;
    @Nullable
    private b.a pzm;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> pzn;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> QF(int i) {
        return this.pzl == i ? com.facebook.common.references.a.b(this.pzn) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> QG(int i) {
        return com.facebook.common.references.a.b(this.pzn);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ak(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b2;
        b2 = com.facebook.common.references.a.b(this.pzn);
        ewI();
        return b2;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean QH(int i) {
        boolean z;
        if (i == this.pzl) {
            z = com.facebook.common.references.a.a(this.pzn);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        ewI();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.pzn.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.pzn != null) {
            }
        }
        com.facebook.common.references.a.c(this.pzn);
        if (this.pzm != null && this.pzl != -1) {
            this.pzm.b(this, this.pzl);
        }
        this.pzn = com.facebook.common.references.a.b(aVar);
        if (this.pzm != null) {
            this.pzm.a(this, i);
        }
        this.pzl = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void ewI() {
        if (this.pzm != null && this.pzl != -1) {
            this.pzm.b(this, this.pzl);
        }
        com.facebook.common.references.a.c(this.pzn);
        this.pzn = null;
        this.pzl = -1;
    }
}
