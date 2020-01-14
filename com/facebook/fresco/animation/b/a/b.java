package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lNM = -1;
    @Nullable
    private b.a lNN;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lNO;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HP(int i) {
        return this.lNM == i ? com.facebook.common.references.a.b((com.facebook.common.references.a) this.lNO) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HQ(int i) {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lNO);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ac(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lNO);
        dmd();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HR(int i) {
        boolean z;
        if (i == this.lNM) {
            z = com.facebook.common.references.a.a(this.lNO);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dmd();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lNO.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lNO != null) {
            }
        }
        com.facebook.common.references.a.c(this.lNO);
        if (this.lNN != null && this.lNM != -1) {
            this.lNN.b(this, this.lNM);
        }
        this.lNO = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        if (this.lNN != null) {
            this.lNN.a(this, i);
        }
        this.lNM = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dmd() {
        if (this.lNN != null && this.lNM != -1) {
            this.lNN.b(this, this.lNM);
        }
        com.facebook.common.references.a.c(this.lNO);
        this.lNO = null;
        this.lNM = -1;
    }
}
