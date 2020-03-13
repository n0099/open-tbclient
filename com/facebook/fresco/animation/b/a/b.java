package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lOG = -1;
    @Nullable
    private b.a lOH;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lOI;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HU(int i) {
        return this.lOG == i ? com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOI) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HV(int i) {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOI);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ad(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOI);
        dnt();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HW(int i) {
        boolean z;
        if (i == this.lOG) {
            z = com.facebook.common.references.a.a(this.lOI);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dnt();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lOI.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lOI != null) {
            }
        }
        com.facebook.common.references.a.c(this.lOI);
        if (this.lOH != null && this.lOG != -1) {
            this.lOH.b(this, this.lOG);
        }
        this.lOI = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        if (this.lOH != null) {
            this.lOH.a(this, i);
        }
        this.lOG = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dnt() {
        if (this.lOH != null && this.lOG != -1) {
            this.lOH.b(this, this.lOG);
        }
        com.facebook.common.references.a.c(this.lOI);
        this.lOI = null;
        this.lOG = -1;
    }
}
