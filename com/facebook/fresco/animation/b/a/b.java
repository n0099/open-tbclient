package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lNH = -1;
    @Nullable
    private b.a lNI;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lNJ;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HP(int i) {
        return this.lNH == i ? com.facebook.common.references.a.b((com.facebook.common.references.a) this.lNJ) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HQ(int i) {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lNJ);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ac(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lNJ);
        dmb();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HR(int i) {
        boolean z;
        if (i == this.lNH) {
            z = com.facebook.common.references.a.a(this.lNJ);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dmb();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lNJ.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lNJ != null) {
            }
        }
        com.facebook.common.references.a.c(this.lNJ);
        if (this.lNI != null && this.lNH != -1) {
            this.lNI.b(this, this.lNH);
        }
        this.lNJ = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        if (this.lNI != null) {
            this.lNI.a(this, i);
        }
        this.lNH = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dmb() {
        if (this.lNI != null && this.lNH != -1) {
            this.lNI.b(this, this.lNH);
        }
        com.facebook.common.references.a.c(this.lNJ);
        this.lNJ = null;
        this.lNH = -1;
    }
}
