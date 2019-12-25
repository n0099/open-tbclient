package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lJW = -1;
    @Nullable
    private b.a lJX;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lJY;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HG(int i) {
        return this.lJW == i ? com.facebook.common.references.a.b((com.facebook.common.references.a) this.lJY) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HH(int i) {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lJY);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ac(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lJY);
        dkW();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HI(int i) {
        boolean z;
        if (i == this.lJW) {
            z = com.facebook.common.references.a.a(this.lJY);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dkW();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lJY.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lJY != null) {
            }
        }
        com.facebook.common.references.a.c(this.lJY);
        if (this.lJX != null && this.lJW != -1) {
            this.lJX.b(this, this.lJW);
        }
        this.lJY = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        if (this.lJX != null) {
            this.lJX.a(this, i);
        }
        this.lJW = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dkW() {
        if (this.lJX != null && this.lJW != -1) {
            this.lJX.b(this, this.lJW);
        }
        com.facebook.common.references.a.c(this.lJY);
        this.lJY = null;
        this.lJW = -1;
    }
}
